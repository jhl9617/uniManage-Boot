package org.webMonster.uniManageBoot.student.courseRegi.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;


public interface CourseRegiRepository extends JpaRepository<CourseRegiEntity, Long> {
    @Query("SELECT C FROM CourseRegiEntity C WHERE C.memberId = :memberId" )
    List<CourseRegiEntity> findByMemberId(@Param("memberId") Long memberId);

}
