package org.webMonster.uniManageBoot.professor.lectureClass.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;

import static org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity.lectureClassEntity;

@Repository
public class LectureClassRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureClassRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public LectureClassRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(LectureClassEntity.class);
        this.queryFactory = queryFactory;
    }


    public Page<LectureClassEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<LectureClassEntity> query = queryFactory.selectFrom(lectureClassEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<LectureClassEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureClassEntity.lectureClassIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    public BooleanExpression searchKeywords(String sk, String sv) {
        if("lecture_room_num".equals(sk)) {   //강의실 호수로 검색
            if(StringUtils.hasLength(sv)) {
                return lectureClassEntity.lectureRoomNum.stringValue().contains(sv);
            }
        } else if ("building_name".equals(sk)) {   //건물명으로 검색
            if(StringUtils.hasLength(sv)) {
                return lectureClassEntity.buildingName.contains(sv);
            }
        } else if ("class_capacity".equals(sk)) {   //수용인원 검색
            if(StringUtils.hasLength(sv)) {
                return lectureClassEntity.classCapacity.stringValue().contains(sv);
            }
        }

        return null;
    }

}
