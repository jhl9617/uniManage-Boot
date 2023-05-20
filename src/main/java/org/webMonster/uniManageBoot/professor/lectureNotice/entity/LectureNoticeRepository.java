package org.webMonster.uniManageBoot.professor.lectureNotice.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface LectureNoticeRepository extends JpaRepository<LectureNoticeEntity, Long> {
    @Query("SELECT l FROM LectureNoticeEntity l WHERE l.lectureId = :lectureId")
    List<LectureNoticeEntity> findByLectureId(@Param("lectureId") Long id);
}
