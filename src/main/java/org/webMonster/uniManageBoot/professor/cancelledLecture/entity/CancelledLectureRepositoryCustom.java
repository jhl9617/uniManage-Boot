package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

public interface CancelledLectureRepositoryCustom {

    //휴강게시글 리스트 출력용
    Page<CancelledLectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);

    BooleanExpression searchKeywords(String sk, String sv);

}

