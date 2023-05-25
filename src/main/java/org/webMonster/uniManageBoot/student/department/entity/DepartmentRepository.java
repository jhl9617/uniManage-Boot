package org.webMonster.uniManageBoot.student.department.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.webMonster.uniManageBoot.student.courseRegi.entity.CourseRegiEntity;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    @Query("SELECT C FROM DepartmentEntity C WHERE C.departmentId = :departmentId" )
    List<DepartmentEntity> findByDepartmentId(@Param("departmentId") Long departmentId);
}
