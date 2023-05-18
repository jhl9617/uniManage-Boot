package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelledLectureRepository extends JpaRepository<CancelledLectureEntity, Long>, CancelledLectureRepositoryCustom {
}
