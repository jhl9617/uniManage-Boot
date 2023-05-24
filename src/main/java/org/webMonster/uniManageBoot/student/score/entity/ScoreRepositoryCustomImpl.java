package org.webMonster.uniManageBoot.student.score.entity;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;

@Repository
public class ScoreRepositoryCustomImpl extends QuerydslRepositorySupport implements ScoreRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ScoreRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(ScoreEntity.class);
        this.queryFactory = queryFactory;
    }

    //교직원 학생관리 학생정보상세 성적 리스트 조회
    public Page<ScoreEntity> findByMemberId(Pageable pageable, Long memberId, SearchCondition searchCondition) {
        QScoreEntity scoreEntity = QScoreEntity.scoreEntity;
        JPAQuery<ScoreEntity> query = queryFactory.selectFrom(scoreEntity)
                .where(scoreEntity.memberId.eq(memberId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        // 페이징 처리
        QueryResults<ScoreEntity> results = query.fetchResults();
        List<ScoreEntity> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
