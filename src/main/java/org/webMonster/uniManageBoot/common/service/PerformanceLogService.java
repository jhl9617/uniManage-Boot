package org.webMonster.uniManageBoot.common.service;



import org.webMonster.uniManageBoot.common.domain.PerformanceLog;

import java.util.List;



public interface PerformanceLogService {

	public void register(PerformanceLog performanceLog) throws Exception;
	
	public List<PerformanceLog> list() throws Exception;

}
