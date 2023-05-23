package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

public interface LectureRoomTimetableRepositoryCustom {

    BooleanExpression searchKeywords(String sk, String sv);

    Page<LectureRoomTimetableEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);

}
