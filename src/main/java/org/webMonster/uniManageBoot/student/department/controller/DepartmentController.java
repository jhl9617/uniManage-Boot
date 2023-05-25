package org.webMonster.uniManageBoot.student.department.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.webMonster.uniManageBoot.student.department.model.dto.DepartmentDto;
import org.webMonster.uniManageBoot.student.department.model.service.DepartmentService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

//    @GetMapping("/student/sugang/{id}")
//    public List<DepartmentDto> departmentList(@PathVariable Long id) {
//        return departmentService.departmentList(id);
//    }
}
