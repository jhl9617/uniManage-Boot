package org.webMonster.uniManageBoot.student.courseRegi.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.webMonster.uniManageBoot.student.courseRegi.entity.CourseRegiEntity;
import org.webMonster.uniManageBoot.student.courseRegi.model.dto.CourseRegiDto;
import org.webMonster.uniManageBoot.student.courseRegi.model.service.CourseRegiService;


import java.util.List;
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CourseRegiController {


    @Autowired
    private CourseRegiService courseRegiService;
    //Eclass 메인화면에서 현재 수강중인 강의 리스트를 조회
    @GetMapping("/eclass/{id}")
    public List<CourseRegiDto> courseRegiList(@PathVariable Long id) {

        return courseRegiService.courseRegiList(id);
    }

    @PostMapping("/courseregi")
    public CourseRegiEntity create(@RequestBody CourseRegiDto courseRegiDto) {

        return courseRegiService.create(courseRegiDto);
    }


}
