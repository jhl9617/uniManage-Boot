package org.webMonster.uniManageBoot.professor.homework.entity;

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

import static org.webMonster.uniManageBoot.professor.homework.entity.QHomeworkEntity.homeworkEntity;


@Repository
public class HomeworkRepositoryCustomImpl extends QuerydslRepositorySupport implements HomeworkRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public HomeworkRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(HomeworkEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<HomeworkEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<HomeworkEntity> query = queryFactory.selectFrom(homeworkEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<HomeworkEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(homeworkEntity.homeworkId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public BooleanExpression searchKeywords(String sk, String sv) {
        if("name".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return null;
            }
        } else if ("homeworkName".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return homeworkEntity.homeworkName.contains(sv);
            }
        } else if ("homeworkContent".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return homeworkEntity.homeworkContent.contains(sv);
            }
        }

        return null;
    }
}
