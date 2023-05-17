package org.webMonster.uniManageBoot.professor.lecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;

public interface LectureRepositoryCustom {
//    Page<LectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);
    
    BooleanExpression searchKeywords(String sk, String sv);

    //교직원 개설강의관리 리스트 출력용
    @Query("SELECT l FROM LectureEntity l WHERE l.lectureApplyStatus = 2")
    Page<LectureEntity> findAllBySearchConditionAndStatus(Pageable pageable, SearchCondition searchCondition);

    //교직원 강의개설요청관리 리스트 출력용
    @Query("SELECT l FROM LectureEntity l WHERE l.lectureApplyStatus = 1")
    Page<LectureEntity> findAllBySearchConditionsAndStatus(Pageable pageable, SearchCondition searchCondition);

}
