package org.webMonster.uniManageBoot.student.courseRegi.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.webMonster.uniManageBoot.student.courseRegi.model.dto.SearchTerm;

import java.util.List;


public interface CourseRegiRepositoryCustom {

    public List<CourseRegiEntity> findAllBySearchTerm(SearchTerm searchTerm);

    public BooleanExpression searchKeywords(Long sv1, String sv2, String sv3);
}
