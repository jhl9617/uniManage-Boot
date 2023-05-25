package org.webMonster.uniManageBoot.student.evaluation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.student.courseRegi.model.dto.CourseRegiDto;
import org.webMonster.uniManageBoot.student.courseRegi.model.service.CourseRegiService;
import org.webMonster.uniManageBoot.student.evaluation.entity.EvaluationEntity;
import org.webMonster.uniManageBoot.student.evaluation.model.dto.EvaluationDto;
import org.webMonster.uniManageBoot.student.evaluation.model.service.EvaluationService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class EvaluationController {


    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private CourseRegiService courseRegiService;

    // 교수가 수강하는 강의에 작성된 평가 리스트 불러오기
    @GetMapping("/prof/stpjastpoj")
    public List<EvaluationDto> evaluationList(@PathVariable Long id) {

        return evaluationService.evaluationList(id);
    }

    // 학생이 수강중인 강의 리스트 조회(선택해서 강의평가 작성할 수 있게)
    @GetMapping("/student/surveycourse/{id}")
    public List<CourseRegiDto> courseRegiList(@PathVariable Long id) {

        return courseRegiService.courseRegiList(id);
    }



    //학생이 강의평가 생성
    @PostMapping("/student/surveycourse")
    public EvaluationEntity create(@RequestBody EvaluationDto evaluationDto) {

        return evaluationService.create(evaluationDto);
    }
}
