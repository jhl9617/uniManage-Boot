package org.webMonster.uniManageBoot.student.freeboard.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;

public interface FreeboardRepositoryCustom {
    public Page<FreeboardEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);

    public BooleanExpression searchKeywords(String sk, String sv);




}
