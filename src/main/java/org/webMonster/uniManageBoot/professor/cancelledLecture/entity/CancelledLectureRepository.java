package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CancelledLectureRepository extends JpaRepository<CancelledLectureEntity, Long> {
//    @Query("SELECT a " +
//            "FROM CancelledLectureEntity a, MemberEntity b, LectureEntity c, LectureClassEntity d" +
//            "WHERE a.memberId(+) = b.memberId" +
//            "AND a.lectureId(+) = c.lectureId" +
//            "AND a.lectureRoomCode(+) = d.lectureRoomCode" +
//            "ORDER BY a.cancelledLectureIdx DESC")
//    List<CancelledLectureEntity>findAllByMemberIdDesc();

}
