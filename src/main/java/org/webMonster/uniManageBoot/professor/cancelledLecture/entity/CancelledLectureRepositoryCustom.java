package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;


public interface CancelledLectureRepositoryCustom {

    //휴강게시글 페이징처리 + 검색기능
    public Page<CancelledLectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);

    //(키워드)검색기능
    public BooleanExpression searchKeyWord(String sk, String sv);

    //휴강게시물 리스트 id로 조회(교수용)
    List<CancelledLectureEntity> findAllBySearchConditionByMemberId(Pageable pageable, SearchCondition searchCondition);
}

