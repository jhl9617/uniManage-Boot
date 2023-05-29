package org.webMonster.uniManageBoot.admin.schedule.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.admin.schedule.entity.ScheduleEntity;
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

    //교직원 학사일정관리 리스트 조회용
    @GetMapping("admin/schedule")
    public Header<List<ScheduleDto>> scheduleList(
            @PageableDefault(sort = {"sche_id"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return scheduleService.getScheduleList(pageable, searchCondition);
    }

    //교직원 학사일정 추가용
    @PostMapping("admin/schedule")
    public ScheduleEntity create(@RequestBody ScheduleDto scheduleDto){
        return scheduleService.create(scheduleDto);
    }

    //교직원 학사일정 수정
    @PatchMapping("admin/schedule")
    public ScheduleDto update(@RequestBody ScheduleDto scheduleDto) {
        ScheduleEntity entity = scheduleService.update(scheduleDto);
        return ScheduleDto.fromEntity(entity);
    }

    //교직원 학사일정 삭제
    @DeleteMapping("admin/schedule/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }
}
