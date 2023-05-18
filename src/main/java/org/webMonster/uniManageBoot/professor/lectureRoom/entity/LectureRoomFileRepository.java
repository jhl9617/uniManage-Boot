package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectureRoomFileRepository extends JpaRepository<LectureRoomFileEntity, Long> {
    @Query("SELECT l FROM LectureRoomFileEntity l Where l.lectureRoomId = :lectureRoomId")
    LectureRoomFileEntity findByLectureRoomId(Long lectureRoomId);
}
