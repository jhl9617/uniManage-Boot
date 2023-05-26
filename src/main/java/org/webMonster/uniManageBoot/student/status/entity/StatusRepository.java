package org.webMonster.uniManageBoot.student.status.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatusRepository extends JpaRepository<StatusEntity, Long>  {
    @Query("SELECT S FROM StatusEntity S WHERE S.memberId = :memberId" )
    List<StatusEntity> findByMemberId(@Param("memberId") Long memberId);
}
