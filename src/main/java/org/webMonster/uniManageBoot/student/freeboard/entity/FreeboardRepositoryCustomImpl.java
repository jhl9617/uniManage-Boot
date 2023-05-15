package org.webMonster.uniManageBoot.student.freeboard.entity;

import com.querydsl.core.types.Projections;
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
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardDto;

import static org.webMonster.uniManageBoot.member.entity.QMemberEntity.memberEntity;
import static org.webMonster.uniManageBoot.student.freeboard.entity.QFreeboardEntity.freeboardEntity;

import java.util.List;

@Repository
public class FreeboardRepositoryCustomImpl extends QuerydslRepositorySupport implements FreeboardRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public FreeboardRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(FreeboardEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<FreeboardEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<FreeboardEntity> query = queryFactory.selectFrom(freeboardEntity)
                .join(freeboardEntity.member, memberEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<FreeboardEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(freeboardEntity.freeId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    public BooleanExpression searchKeywords(String sk, String sv) {
        if("name".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return freeboardEntity.member.name.contains(sv);
            }
        } else if ("freeTitle".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return freeboardEntity.freeTitle.contains(sv);
            }
        } else if ("freeContent".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return freeboardEntity.freeContent.contains(sv);
            }
        }

        return null;
    }


    public List<FreeboardDto> findAllFreeboardWithMember() {

        return queryFactory
                .select(Projections.bean(
                        FreeboardDto.class,
                        freeboardEntity.memberId,
                        freeboardEntity.freeId,
                        freeboardEntity.freeTitle,
                        freeboardEntity.freeContent,
                        freeboardEntity.createdDate,
                        memberEntity.name))
                .from(freeboardEntity)
                .join(freeboardEntity.member, memberEntity)
                .fetch();
    }
}
