package org.webMonster.uniManageBoot.professor.lectureNotice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureNotice.entity.LectureNoticeEntity;
import org.webMonster.uniManageBoot.professor.lectureNotice.model.dto.LectureNoticeDto;
import org.webMonster.uniManageBoot.professor.lectureNotice.model.service.LectureNoticeService;


import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class LectureNoticeController {

    @Autowired
    private LectureNoticeService lectureNoticeService;
    // 게시물 리스트 조회, 조회때부터 id값을 받아야 해서 기존 코드 방식에서 수정함
    @GetMapping("/eclass/lecture/notice/list")
    public Header<List<LectureNoticeDto>> lectureNoticeList(
            @PageableDefault(sort = {"lecture_notice_id"}) Pageable pageable,
            SearchCondition searchCondition,
            @RequestParam("lecture_id") Long id
    ) {
        return lectureNoticeService.getLectureNoticeList(pageable, searchCondition, id);
    }

    // 게시물 선택 조회
    @GetMapping("/eclass/lecture/notice/detail")
    public LectureNoticeDto getLectureNotice(@RequestParam("lecture_notice_id") Long id) {

            lectureNoticeService.increaseReadCount(id);

            return lectureNoticeService.getLectureNotice(id);
    }

    // 교수 강의 공지 리스트
    @GetMapping("/prof/lecture/notice/list")
    public Header<List<LectureNoticeDto>> profLectureNoticeList(
            @PageableDefault(sort = {"lecture_notice_id"}) Pageable pageable,
            SearchCondition searchCondition,
            @RequestParam("lecture_id") Long id
    ) {
        return lectureNoticeService.getLectureNoticeList(pageable, searchCondition, id);
    }

    // 교수 강의 공지 선택 조회
    @GetMapping("/prof/lecture/notice/detail")
    public LectureNoticeDto getProfLectureNotice(@RequestParam("lecture_notice_id") Long id) {

        lectureNoticeService.increaseReadCount(id);

        return lectureNoticeService.getLectureNotice(id);
    }

    // 교수 강의 공지 작성
    @PostMapping("/prof/lecture/notice")
    public LectureNoticeEntity create(@RequestBody LectureNoticeDto lectureNoticeDto) {

        return lectureNoticeService.create(lectureNoticeDto);
    }

    // 교수 강의 공지 수정
    @PatchMapping("/prof/lecture/notice")
    public LectureNoticeEntity update(@RequestBody LectureNoticeDto lectureNoticeDto) {

        return lectureNoticeService.update(lectureNoticeDto);
    }
    // 게시글 삭제
    @DeleteMapping("/prof/lecture/notice/{id}")
    public void delete(@PathVariable Long id) {
       lectureNoticeService.delete(id);
    }


}
