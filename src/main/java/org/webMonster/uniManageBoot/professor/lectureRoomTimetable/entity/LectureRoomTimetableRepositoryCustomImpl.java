package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity;
import org.webMonster.uniManageBoot.professor.lectureClassTime.entity.QLectureClassTimeEntity;

import java.util.List;

import static org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity.lectureEntity;
import static org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity.lectureRoomTimetableEntity;

@Repository
@Primary
public class LectureRoomTimetableRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureRoomTimetableRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public LectureRoomTimetableRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(LectureRoomTimetableEntity.class);
        this.queryFactory = queryFactory;
    }

    public Page<LectureRoomTimetableEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<LectureRoomTimetableEntity> query = queryFactory.selectFrom(lectureRoomTimetableEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(lectureRoomTimetableEntity.operation.eq('N'));

        long total = query.fetchCount();

        List<LectureRoomTimetableEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureRoomTimetableEntity.lectureRoomTimetableIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    public BooleanExpression searchKeywords(String sk, String sv) {
        if ("building_name".equals(sk)) {   // 건물이름으로 검색
            if (StringUtils.hasLength(sv)) {
                QLectureClassEntity lectureClassEntity = QLectureClassEntity.lectureClassEntity;
                return lectureClassEntity.buildingName.contains(sv);
            }
        } else if ("day_time".equals(sk)) {   // 요일로 검색
            if (StringUtils.hasLength(sv)) {
                QLectureClassTimeEntity lectureClassTimeEntity = QLectureClassTimeEntity.lectureClassTimeEntity;
                return lectureClassTimeEntity.dayTime.contains(sv);
            }
        } else if ("lecture_room_num".equals(sk)) {   // 강의실호수로 검색
            if (StringUtils.hasLength(sv)) {
                QLectureClassEntity lectureClassEntity = QLectureClassEntity.lectureClassEntity;
                return lectureClassEntity.lectureRoomNum.stringValue().contains(sv);
            }
        }

        return null;
    }
}

