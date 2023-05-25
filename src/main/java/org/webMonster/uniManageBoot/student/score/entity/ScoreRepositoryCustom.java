package org.webMonster.uniManageBoot.student.score.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.student.status.entity.StatusEntity;

import java.util.List;

public interface ScoreRepositoryCustom {
    //교직원 학생관리 학생정보상세 성적 리스트 조회
    Page<ScoreEntity> findByMemberId(Pageable pageable, Long memberId, SearchCondition searchCondition);


}

