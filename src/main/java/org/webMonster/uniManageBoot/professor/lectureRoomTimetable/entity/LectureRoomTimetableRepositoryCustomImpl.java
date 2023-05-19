package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;

import static org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity.lectureRoomTimetableEntity;

public class LectureRoomTimetableRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureRoomTimetableRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public LectureRoomTimetableRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(LectureRoomTimetableEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<LectureRoomTimetableEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<LectureRoomTimetableEntity> query = queryFactory.selectFrom(lectureRoomTimetableEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.fetchCount();

        List<LectureRoomTimetableEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureRoomTimetableEntity.lectureRoomTimetableIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    public BooleanExpression searchKeywords(String sk, String sv) {
        if ("buildingName".equals(sk)) {   // 건물이름으로 검색
            if (StringUtils.hasLength(sv)) {
                return lectureRoomTimetableEntity.lectureClass.buildingName.contains(sv);
            }
        } else if ("dayTime".equals(sk)) {   // 요일로 검색
            if (StringUtils.hasLength(sv)) {
                return lectureRoomTimetableEntity.lectureClassTime.dayTime.contains(sv);
            }
        } else if ("lectureRoomNum".equals(sk)) {   // 강의실호수로 검색
            if (StringUtils.hasLength(sv)) {
                return lectureRoomTimetableEntity.lectureClass.lectureRoomNum.contains(sv);
            }
        }

        return null;
    }
}

