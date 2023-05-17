package org.webMonster.uniManageBoot.student.courseRegi.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.webMonster.uniManageBoot.student.courseRegi.entity.CourseRegiEntity;
import org.webMonster.uniManageBoot.student.courseRegi.model.dto.CourseRegiDto;
import org.webMonster.uniManageBoot.student.courseRegi.model.service.CourseRegiService;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardDto;


import java.util.List;
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CourseRegiController {


    @Autowired
    private CourseRegiService courseRegiService;

    @GetMapping("/Eclass")
    public List<CourseRegiDto> courseRegiList(Long id) {
        id = 20180102L;
        return courseRegiService.courseRegiList(id);
    }

    @PostMapping("/courseregi")
    public CourseRegiEntity create(@RequestBody CourseRegiDto courseRegiDto) {

        return courseRegiService.create(courseRegiDto);
    }
}
