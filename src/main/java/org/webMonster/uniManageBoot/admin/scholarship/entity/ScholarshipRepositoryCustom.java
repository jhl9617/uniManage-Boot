package org.webMonster.uniManageBoot.admin.scholarship.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

public interface ScholarshipRepositoryCustom {

    Page<ScholarshipEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);

    BooleanExpression searchKeywords(String sk, String sv);

    //교직원 학생관리 학생정보상세 장학금 리스트 조회
    Page<ScholarshipEntity> findByMemberId(Pageable pageable, Long memberId, SearchCondition searchCondition);
}
