package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.common.SearchRoom;

public interface LectureRoomTimetableRepositoryCustom {

    BooleanExpression searchKeywords(String sv1, String sv2, String sv3);

    Page<LectureRoomTimetableEntity> findAllBySearchConditionAndStatus(Pageable pageable, SearchRoom searchRoom);

}
