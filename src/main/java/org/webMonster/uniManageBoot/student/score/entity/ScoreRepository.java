package org.webMonster.uniManageBoot.student.score.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {

    @Query("SELECT S FROM ScoreEntity S WHERE S.memberId = :memberId" )
    List<ScoreEntity> findByMemberId(@Param("memberId") Long memberId);
}
