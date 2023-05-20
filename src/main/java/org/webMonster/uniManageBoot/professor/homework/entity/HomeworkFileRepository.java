package org.webMonster.uniManageBoot.professor.homework.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HomeworkFileRepository extends JpaRepository<HomeworkFileEntity, Long> {
    @Query("SELECT h FROM HomeworkFileEntity h Where h.homeworkId = :homeworkId")
    HomeworkFileEntity findbyHomeworkId(@Param("homeworkId") Long homeworkId);
}
