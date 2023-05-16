package org.webMonster.uniManageBoot.professor.lecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;

public interface LectureRepositoryCustom {

    public Page<LectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);

    public BooleanExpression searchKeywords(String sk, String sv);
}
