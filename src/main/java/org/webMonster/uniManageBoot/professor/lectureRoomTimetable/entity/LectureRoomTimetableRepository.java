package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRoomTimetableRepository extends JpaRepository<LectureRoomTimetableEntity, Long> {
    /*@Query("SELECT n FROM LectureRoomTimetableEntity n ORDER BY n.lectureRoomTimetableIdx DESC")
    Page<LectureRoomTimetableEntity> findAllByOrderByLectureRoomTimetableIdxDesc(Pageable pageable);*/
}
