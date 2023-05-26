package org.webMonster.uniManageBoot.student.courseRegi.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchRoom;


public interface CourseRegiRepositoryCustom {

    public Page<CourseRegiEntity> findAllBySearchCondition(Pageable pageable, SearchRoom searchRoom);

    public BooleanExpression searchKeywords(String sv1, String sv2);
}
