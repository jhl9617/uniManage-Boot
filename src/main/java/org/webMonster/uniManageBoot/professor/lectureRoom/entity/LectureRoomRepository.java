package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRoomRepository extends JpaRepository<LectureRoomEntity, Long> {


    @Query("SELECT l FROM LectureRoomEntity l WHERE l.lectureId = :lectureId")
    List<LectureRoomEntity> findByLectureId(@Param("lectureId") Long id);
}
