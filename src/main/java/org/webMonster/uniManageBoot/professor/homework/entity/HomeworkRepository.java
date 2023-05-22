package org.webMonster.uniManageBoot.professor.homework.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<HomeworkEntity, Long> {
    @Query("SELECT l FROM HomeworkEntity l Where l.lectureId = :lectureId")
    List<HomeworkEntity> findByLectureId(@Param("lectureId") Long id);
}
