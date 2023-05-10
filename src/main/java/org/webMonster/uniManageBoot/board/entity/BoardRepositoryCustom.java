package org.webMonster.uniManageBoot.board.entity;

import org.webMonster.uniManageBoot.common.SearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.webMonster.uniManageBoot.board.entity.QBoardEntity.boardEntity;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Page<BoardEntity> findAllBySearchCondition(Pageable pageable) {
        JPAQuery<BoardEntity> query = queryFactory.selectFrom(boardEntity);


        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<BoardEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(boardEntity.idx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }
}