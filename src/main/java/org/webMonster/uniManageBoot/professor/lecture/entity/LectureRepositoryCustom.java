package org.webMonster.uniManageBoot.professor.lecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.SearchValues;

public interface LectureRepositoryCustom {

    BooleanExpression searchKeywords(String sk, String sv);

    //교직원 개설강의관리 리스트 출력용
    Page<LectureEntity> findAllBySearchConditionAndStatus(Pageable pageable, SearchCondition searchCondition);

    //교직원 강의개설요청관리 리스트 출력용
    Page<LectureEntity> findAllBySearchConditionsAndStatus(Pageable pageable, SearchCondition searchCondition);

    //교수 개설강의관리 리스트 출력용
    Page<LectureEntity> findBySearchConditionAndStatus(Pageable pageable, SearchCondition searchCondition, Long memberId);

    //학생 학생정보시스템 수강신청 가능한 강의 리스트 출력용
    Page<LectureEntity> findAllBySearchRoomAndStatus(Pageable pageable, SearchCondition searchCondition);

    BooleanExpression searchKeyword(String sk, String sv);
    //학생 학과별 강의목록 출력용
    Page<LectureEntity> findBySearchValues(Pageable pageable, SearchValues searchValues);

    BooleanExpression searchValues(String sv1, String sv2, String sv3, Long sv4);
}
