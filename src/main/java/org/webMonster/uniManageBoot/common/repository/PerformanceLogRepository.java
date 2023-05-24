package org.webMonster.uniManageBoot.common.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.webMonster.uniManageBoot.common.domain.PerformanceLog;

public interface PerformanceLogRepository extends JpaRepository<PerformanceLog, Long> {
	
}
