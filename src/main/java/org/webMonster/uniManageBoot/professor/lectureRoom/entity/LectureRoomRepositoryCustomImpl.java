package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

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

import static org.webMonster.uniManageBoot.professor.lectureRoom.entity.QLectureRoomEntity.lectureRoomEntity;

@Repository
public class LectureRoomRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureRoomRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public LectureRoomRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(LectureRoomEntity.class);
        this.queryFactory = queryFactory;
    }
    @Override
    public Page<LectureRoomEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition, Long id) {
        JPAQuery<LectureRoomEntity> query = queryFactory.selectFrom(lectureRoomEntity)
                .where(lectureRoomEntity.lectureId.eq(id))
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<LectureRoomEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureRoomEntity.lectureRoomId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public BooleanExpression searchKeywords(String sk, String sv) {
        if("name".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return null;
            }
        } else if ("lectureRoomTitle".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return lectureRoomEntity.lectureRoomTitle.contains(sv);
            }
        } else if ("lectureRoomContent".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return lectureRoomEntity.lectureRoomContent.contains(sv);
            }
        }

        return null;
    }
}
