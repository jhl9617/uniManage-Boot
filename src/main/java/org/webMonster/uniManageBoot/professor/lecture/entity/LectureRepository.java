package org.webMonster.uniManageBoot.professor.lecture.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectureRepository extends JpaRepository<LectureEntity, Long> {

}
