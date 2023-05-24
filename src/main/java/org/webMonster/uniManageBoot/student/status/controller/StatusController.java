package org.webMonster.uniManageBoot.student.status.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.student.status.entity.StatusEntity;
import org.webMonster.uniManageBoot.student.status.model.dto.StatusDto;
import org.webMonster.uniManageBoot.student.status.model.service.StatusService;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class StatusController {
    private final StatusService statusService;

    //학생 휴학신청 추가
    @PostMapping("student/takeoff")
    public StatusEntity createTakeOff(@RequestBody StatusDto statusDto) {
        return statusService.createTakeOff(statusDto);
    }

    //학생 휴학신청 후 확인페이지로 넘어감
    @GetMapping("student/takeoff/{id}")
    public StatusDto getTakeoffAppliedView(@PathVariable Long id) {
     return statusService.getStatusAppliedView(id);
    }

    //학생 복학신청 추가
    @PostMapping("student/return")
    public StatusEntity createReturn(@RequestBody StatusDto statusDto) {
        return statusService.createReturn(statusDto);
    }

    //학생 복학신청 후 확인페이지로 넘어감
    @GetMapping("student/return/{id}")
    public StatusDto getReturnAppliedView(@PathVariable Long id) {
        return statusService.getStatusAppliedView(id);
    }



}
