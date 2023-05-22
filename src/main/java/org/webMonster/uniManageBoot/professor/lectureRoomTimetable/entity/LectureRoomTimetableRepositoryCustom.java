package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;

public interface LectureRoomTimetableRepositoryCustom {
    Page<LectureRoomTimetableEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition);

}
