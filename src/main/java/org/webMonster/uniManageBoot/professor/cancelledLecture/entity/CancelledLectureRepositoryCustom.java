package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

public interface CancelledLectureRepositoryCustom {

    //본인이 작성한 휴강신청 리스트 조회(교수용)
    Page<CancelledLectureEntity> findAllBySearchConditionByMemberId(Pageable pageable, SearchCondition searchCondition, long memberId);

    BooleanExpression searchKeywords(String sk, String sv);

}

