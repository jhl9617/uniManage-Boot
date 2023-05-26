package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

public interface CancelledLectureRepositoryCustom {

    //교수전체 휴강신청 리스트 조회(교직원용)
    Page<CancelledLectureEntity> findAllBySearchConditionAndStatus(Pageable pageable, SearchCondition searchCondition);

    //교수 휴강신청 리스트 조회(교수용)
    Page<CancelledLectureEntity> findAllBySearchConditionAndStatusByMemberId(Pageable pageable, SearchCondition searchCondition, Long memberId);

    //검색용(교직원)
    BooleanExpression searchKeywords(String sk, String sv);
}

