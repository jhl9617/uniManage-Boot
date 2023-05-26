package org.webMonster.uniManageBoot.common.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.webMonster.uniManageBoot.common.domain.AccessLog;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
	
}
