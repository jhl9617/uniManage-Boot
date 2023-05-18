package org.webMonster.uniManageBoot.professor.lectureNotice.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;

import static org.webMonster.uniManageBoot.professor.lectureNotice.entity.QLectureNoticeEntity.lectureNoticeEntity;


public class LectureNoticeRepositoryCustomImpl extends QuerydslRepositorySupport implements LectureNoticeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public LectureNoticeRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(LectureNoticeEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<LectureNoticeEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition, Long id) {
        JPAQuery<LectureNoticeEntity> query = queryFactory.selectFrom(lectureNoticeEntity)
                .where(lectureNoticeEntity.lectureId.eq(id))
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<LectureNoticeEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(lectureNoticeEntity.lectureNoticeId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public BooleanExpression searchKeywords(String sk, String sv) {
        return null;
    }
}
