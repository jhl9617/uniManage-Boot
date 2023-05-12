package org.webMonster.uniManageBoot.admin.scholarship.entity;

import com.querydsl.core.annotations.QueryEmbedded;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.webMonster.uniManageBoot.admin.scholarship.model.service.ScholarshipService;

public interface ScholarshipRepository extends JpaRepository<ScholarshipEntity, Long> {

    @Query("SELECT scho FROM ScholarshipEntity scho ORDER BY scho.schoId DESC")
    Page<ScholarshipEntity> findAllByOrderByIdxDesc(Pageable pageable);
}
