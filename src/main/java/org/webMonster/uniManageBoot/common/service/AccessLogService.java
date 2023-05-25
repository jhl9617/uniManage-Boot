package org.webMonster.uniManageBoot.common.service;



import org.webMonster.uniManageBoot.common.domain.AccessLog;

import java.util.List;

public interface AccessLogService {

	public void register(AccessLog accessLog) throws Exception;

	public List<AccessLog> list() throws Exception;

}
