package org.webMonster.uniManageBoot.admin.schedule.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;

import static org.webMonster.uniManageBoot.admin.schedule.entity.QScheduleEntity.scheduleEntity;

@RequiredArgsConstructor
@Repository
public class ScheduleRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public Page<ScheduleEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<ScheduleEntity> query = queryFactory.selectFrom(scheduleEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<ScheduleEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(scheduleEntity.scheId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    public BooleanExpression searchKeywords(String sk, String sv) {
        if("sche_title".equals(sk)) {   //학사일정 제목으로 검색
            if(StringUtils.hasLength(sv)) {
                return scheduleEntity.scheTitle.contains(sv);
            }
        } else if ("sche_content".equals(sk)) {   //학사일정 내용으로 검색
            if(StringUtils.hasLength(sv)) {
                return scheduleEntity.scheContent.contains(sv);
            }
        }

        return null;
    }

}
