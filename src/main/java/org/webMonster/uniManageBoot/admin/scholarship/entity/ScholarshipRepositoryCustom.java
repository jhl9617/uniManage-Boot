package org.webMonster.uniManageBoot.admin.scholarship.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

public interface ScholarshipRepositoryCustom {

    public Page<ScholarshipEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);

    public BooleanExpression searchKeywords(String sk, String sv);
}
