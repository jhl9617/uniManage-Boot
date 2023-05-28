package org.webMonster.uniManageBoot.professor.cancelledLecture.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    //교수전체 휴강신청 리스트 조회(교직원용)
    @GetMapping("/admin/manage/closelecture")
    public Header<List<CancelledLectureDto>> adminCancelledLectureList(
            @PageableDefault(sort = {"cancelledLectureIdx"})Pageable pageable, SearchCondition searchCondition){
        return cancelledLectureService.getAdminCancelledLectureList(pageable, searchCondition);
    }


    //교수 휴강신청 리스트 조회(교수용)
    @GetMapping("/prof/lecture/cancelled/list")
    public Header<List<CancelledLectureDto>> profCancelledLectureList(
            @PageableDefault(sort = {"cancelledLectureIdx"})Pageable pageable, SearchCondition searchCondition, HttpSession session){
        MemberDepartmentDto memberDepartmentDto  = (MemberDepartmentDto) session.getAttribute("loginMember");
        Long memberId = memberDepartmentDto.getMemberId();
        System.out.println("컨트롤러" + memberDepartmentDto);
        return cancelledLectureService.getProfCancelledLectureList(pageable, searchCondition, memberId);
    }


    //휴강신청 상세보기
    @GetMapping("prof/lecture/cancelled/{id}")
    public CancelledLectureDto getProfCancelledLecture(@PageableDefault Long id){
        return cancelledLectureService.getCancelledLecture(id);
    }


    //휴강게시글 생성(교수용)
    @PostMapping("/prof/lecture/cancelled/write")
    public CancelledLectureEntity create(@RequestBody CancelledLectureDto cancelledLectureDto, HttpSession session){
        MemberDepartmentDto  memberDepartmentDto  = (MemberDepartmentDto) session.getAttribute("loginMember");
        Long memberId = memberDepartmentDto.getMemberId();
        System.out.println(cancelledLectureDto);
        return cancelledLectureService.create(cancelledLectureDto);
    }


    //휴강게시글 승인여부 수정(교직원용)
    @PatchMapping  ("/admin/manage/closelecture")
    public CancelledLectureEntity update(@RequestBody ApplyDto applyDto){
        return cancelledLectureService.update(applyDto);
    }
}
