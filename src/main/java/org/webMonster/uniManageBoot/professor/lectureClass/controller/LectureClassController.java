package org.webMonster.uniManageBoot.professor.lectureClass.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;
import org.webMonster.uniManageBoot.professor.lectureClass.model.dto.LectureClassDto;
import org.webMonster.uniManageBoot.professor.lectureClass.model.service.LectureClassService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class LectureClassController {
    private final LectureClassService lectureClassService;


    //교직원 강의실관리 리스트 조회
    @GetMapping("/admin/manage/classroom")
    public Header<List<LectureClassDto>> lectureClassList(
            @PageableDefault(sort = {"lectureClassIdx"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return lectureClassService.getLectureClassList(pageable, searchCondition);
    }

    //교직원 강의실관리 상세보기글 조회
    @GetMapping("/admin/manage/classroom/{id}")
    public LectureClassDto getLectureClass(@PathVariable Long id) { return lectureClassService.getLectureClass(id); }

    //교직원 강의실관리 추가하기
    @PostMapping("/admin/manage/classroom")
    public LectureClassEntity create(@RequestBody LectureClassDto lectureClassDto) { return lectureClassService.create(lectureClassDto); }

    //교직원 강의실관리 수정하기
    @PatchMapping("/admin/manage/classroom")
    public LectureClassEntity update(@RequestBody LectureClassDto lectureClassDto){ return lectureClassService.update(lectureClassDto); }

    //교직원 강의실관리 삭제하기
    @DeleteMapping("/admin/manage/classroom/{id}")
    public void delete(@PathVariable Long id) { lectureClassService.delete(id); }
}
