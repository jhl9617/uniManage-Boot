package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectureRoomTimetableRepository extends JpaRepository<LectureRoomTimetableEntity, Long> {
    @Query("SELECT n FROM LectureRoomTimetableEntity n ORDER BY n.lectureRoomTimetableIdx DESC")
    Page<LectureRoomTimetableEntity> findAllByOrderByLectureRoomTimetableIdxDesc(Pageable pageable);
}
