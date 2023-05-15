package org.webMonster.uniManageBoot.common.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.domain.PerformanceLog;
import org.webMonster.uniManageBoot.common.repository.PerformanceLogRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PerformanceLogServiceImpl implements PerformanceLogService {

	private final PerformanceLogRepository repository;

	@Override
	public void register(PerformanceLog performanceLog) throws Exception {
		repository.save(performanceLog);
	}
	
	@Override
	public List<PerformanceLog> list() throws Exception {
		return repository.findAll(Sort.by(Direction.DESC, "logNo"));
	}

}
