package org.webMonster.uniManageBoot.professor.lectureNotice.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardRepEntity;

import java.util.List;
import java.util.Optional;

public interface LectureNoticeRepository extends JpaRepository<LectureNoticeEntity, Long> {

}
