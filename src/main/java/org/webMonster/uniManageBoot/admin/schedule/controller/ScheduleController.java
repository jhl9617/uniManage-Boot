package org.webMonster.uniManageBoot.admin.schedule.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webMonster.uniManageBoot.admin.schedule.model.dto.ScheduleDto;
import org.webMonster.uniManageBoot.admin.schedule.model.service.ScheduleService;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/admin/schedule")
    public Header<List<ScheduleDto>> scheduleList(
            @PageableDefault(sort = {"sche_id"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return scheduleService.getScheduleList(pageable, searchCondition);
    }

}
