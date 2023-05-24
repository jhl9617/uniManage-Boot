package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchRoom;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity;
import org.webMonster.uniManageBoot.professor.lectureClassTime.entity.QLectureClassTimeEntity;

import java.util.List;

import static org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity.lectureClassEntity;
import static org.webMonster.uniManageBoot.professor.lectureClassTime.entity.QLectureClassTimeEntity.lectureClassTimeEntity;
import static org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.QLectureRoomTimetableEntity.lectureRoomTimetableEntity;

@Repository
public class LectureRoomTimetableRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureRoomTimetableRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public LectureRoomTimetableRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(LectureRoomTimetableEntity.class);
        this.queryFactory = queryFactory;
    }

    public Page<LectureRoomTimetableEntity> findAllBySearchConditionAndStatus(Pageable pageable, SearchRoom searchRoom) {
        JPAQuery<LectureRoomTimetableEntity> query = queryFactory.selectFrom(lectureRoomTimetableEntity)
                .join(lectureRoomTimetableEntity.lectureClass, lectureClassEntity)
                .on(lectureRoomTimetableEntity.lectureRoomCode.eq(lectureClassEntity.lectureRoomCode))
                .join(lectureRoomTimetableEntity.lectureClassTime, lectureClassTimeEntity)
                .on(lectureRoomTimetableEntity.timecode.eq(lectureClassTimeEntity.timecode))
                .where(searchKeywords(searchRoom.getSv1(), searchRoom.getSv2(), searchRoom.getSv3()));
//                        .and(lectureRoomTimetableEntity.operation.eq('N')));

        long total = query.fetchCount();

        List<LectureRoomTimetableEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureRoomTimetableEntity.lectureRoomTimetableIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    public BooleanExpression searchKeywords(String sv1, String sv2, String sv3) {
        QLectureClassEntity lectureClassEntity = QLectureClassEntity.lectureClassEntity;
        QLectureClassTimeEntity lectureClassTimeEntity = QLectureClassTimeEntity.lectureClassTimeEntity;

        BooleanExpression expression = null;

        if (StringUtils.hasLength(sv1)) {
            expression = lectureClassEntity.buildingName.contains(sv1);
        }

        if (StringUtils.hasLength(sv2)) {
            BooleanExpression roomNumExpression = lectureClassEntity.lectureRoomNum.contains(sv2);
            expression = (expression != null) ? expression.and(roomNumExpression) : roomNumExpression;
        }

        if (StringUtils.hasLength(sv3)) {
            BooleanExpression dayTimeExpression = lectureClassTimeEntity.dayTime.contains(sv3);
            expression = (expression != null) ? expression.and(dayTimeExpression) : dayTimeExpression;
        }

        if (expression != null) {
            return lectureRoomTimetableEntity.lectureRoomCode.in(
                    JPAExpressions.select(lectureClassEntity.lectureRoomCode)
                            .from(lectureClassEntity)
                            .where(expression)
            );
        }

        return null;
    }
}

