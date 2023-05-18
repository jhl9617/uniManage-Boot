package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureRoomRepository extends JpaRepository<LectureRoomEntity, Long> {


}
