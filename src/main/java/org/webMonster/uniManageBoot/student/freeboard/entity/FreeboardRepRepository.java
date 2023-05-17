package org.webMonster.uniManageBoot.student.freeboard.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreeboardRepRepository extends JpaRepository<FreeboardRepEntity, Long> {
    @Query("SELECT f FROM FreeboardRepEntity f Where f.freeId = :freeId")
    List<FreeboardRepEntity> findByFreeId(@Param("freeId") Long freeId);

}
