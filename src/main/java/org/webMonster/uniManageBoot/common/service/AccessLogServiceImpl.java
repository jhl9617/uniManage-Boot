package org.webMonster.uniManageBoot.common.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.domain.AccessLog;
import org.webMonster.uniManageBoot.common.repository.AccessLogRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccessLogServiceImpl implements AccessLogService {

	private final AccessLogRepository repository;

	@Override
	public void register(AccessLog accessLog) throws Exception {
		repository.save(accessLog);
	}

	@Override
	public List<AccessLog> list() throws Exception {
		return repository.findAll(Sort.by(Direction.DESC, "logNo"));
	}

}
