package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity;

public interface LectureRoomRepositoryCustom {

    public Page<LectureRoomEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition, Long id);

    public BooleanExpression searchKeywords(String sk, String sv);
}
