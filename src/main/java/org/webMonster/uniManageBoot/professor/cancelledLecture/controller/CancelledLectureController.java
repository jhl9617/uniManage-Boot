package org.webMonster.uniManageBoot.professor.cancelledLecture.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureEntity;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.ApplyDto;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.CancelledLectureDto;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.service.CancelledLectureService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CancelledLectureController {
    @Autowired
    private CancelledLectureService cancelledLectureService;

    //휴강신청 리스트 전체조회(교직원용)
//    @GetMapping("/admin/manage/closelecture")
//    public Header<List<CancelledLectureDto>> cancelledLectureList(
//            @PageableDefault(sort = {"Cancelled_lecture_idx_seq"})Pageable pageable,
//            SearchCondition searchCondition, HttpSession session
//    ){
//        return cancelledLectureService.getCancelledLectureList(pageable, searchCondition, session);
//    }


    //본인이 작성한 휴강신청 리스트 조회(교수용)
    @GetMapping("/prof/lecture/cancelled/list")
    public Header<List<CancelledLectureDto>> cancelledLectureList(
            @PageableDefault(sort = {"Cancelled_lecture_idx_seq"})Pageable pageable, SearchCondition searchCondition, HttpSession session){
        MemberDepartmentDto sessionMember = (MemberDepartmentDto) session.getAttribute("loginMember");
        Long memberId = sessionMember.getMemberId();
        return cancelledLectureService.getCancelledLectureList(pageable, searchCondition, memberId);
    }



    //휴강게시물 작성(교수용)
    @PostMapping("/prof/lecture/cancelled/write")
    public CancelledLectureEntity create(@RequestBody CancelledLectureDto cancelledLectureDto){
        return cancelledLectureService.create(cancelledLectureDto);
    }


    //휴강게시글 승인여부 수정(교직원용)
    @PatchMapping  ("/admin/manage/closelecture")
    public CancelledLectureEntity update(@RequestBody ApplyDto applyDto){
        return cancelledLectureService.update(applyDto);
    }
}
