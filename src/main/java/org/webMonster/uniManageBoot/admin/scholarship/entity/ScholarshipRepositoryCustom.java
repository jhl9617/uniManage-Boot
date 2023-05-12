package org.webMonster.uniManageBoot.admin.scholarship.entity;

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

import static org.webMonster.uniManageBoot.admin.scholarship.entity.QScholarshipEntity.scholarshipEntity;

//교직원 장학금관리 리스트에서 검색용
@RequiredArgsConstructor
@Repository
public class ScholarshipRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    public Page<ScholarshipEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<ScholarshipEntity> query = queryFactory.selectFrom(scholarshipEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<ScholarshipEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(scholarshipEntity.schoId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if("member_id".equals(sk)) {   //학생번호(이름)으로 검색
            if(StringUtils.hasLength(sv)) {
                long memberId;
                try {
                    memberId = Long.parseLong(sv);
                } catch (NumberFormatException e) {
                    return null; // Invalid input, skip filtering
                }
            }
        } else if ("scho_name".equals(sk)) {   //장학금명으로 검색
            if(StringUtils.hasLength(sv)) {
                return scholarshipEntity.schoName.contains(sv);
            }
        }

        return null;
    }
}
