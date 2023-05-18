package org.webMonster.uniManageBoot.professor.lectureNotice.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

public interface LectureNoticeRepositoryCustom {

    public Page<LectureNoticeEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition, Long id);

    public BooleanExpression searchKeywords(String sk, String sv);
}
