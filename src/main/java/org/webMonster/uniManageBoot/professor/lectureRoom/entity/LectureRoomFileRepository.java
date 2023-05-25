package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LectureRoomFileRepository extends JpaRepository<LectureRoomFileEntity, Long> {
    @Query("SELECT l FROM LectureRoomFileEntity l Where l.lectureRoomId = :lectureRoomId")
    LectureRoomFileEntity findByLectureRoomId(@Param("lectureRoomId") Long lectureRoomId);
}
