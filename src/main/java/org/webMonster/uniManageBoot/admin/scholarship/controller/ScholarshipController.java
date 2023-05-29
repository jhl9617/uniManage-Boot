package org.webMonster.uniManageBoot.admin.scholarship.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.admin.scholarship.entity.ScholarshipEntity;
import org.webMonster.uniManageBoot.admin.scholarship.model.dto.ScholarshipDto;
import org.webMonster.uniManageBoot.admin.scholarship.model.service.ScholarshipService;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.member.model.dto.MemberDto;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ScholarshipController {
    private final ScholarshipService scholarshipService;

    //교직원 장학금관리 리스트 조회
    @GetMapping("/admin/manage/scholarship")
    public Header<List<ScholarshipDto>> scholarshipList(
            @PageableDefault(sort = {"schoId"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return scholarshipService.getScholarshipList(pageable, searchCondition);
    }

    //교직원 장학금관리 상세보기글 조회
    @GetMapping("/admin/manage/scholarship/{id}")
    public ScholarshipDto getScholarship(@PathVariable Long id) { return scholarshipService.getScholarship(id); }

    //교직원 장학금관리 추가하기
    @PostMapping("/admin/manage/scholarship")
    public ScholarshipEntity create(@RequestBody ScholarshipDto scholarshipDto) { return scholarshipService.create(scholarshipDto); }

    //교직원 장학금관리 수정하기
    @PatchMapping("/admin/manage/scholarship")
    public ScholarshipDto update(@RequestBody ScholarshipDto scholarshipDto) {
        ScholarshipEntity entity = scholarshipService.update(scholarshipDto);
        return ScholarshipDto.fromEntity(entity);
    }

    //교직원 장학금관리 삭제하기
    @DeleteMapping("/admin/manage/scholarship/{id}")
    public void delete(@PathVariable Long id) { scholarshipService.delete(id); }

    //교직원 학생관리 학생정보상세 장학금 리스트 조회
    @GetMapping("/admin/manage/student/scholarship/{member_id}")
    public Header<List<ScholarshipDto>> studentSchoList(
            @PageableDefault(sort = {"schoId"}) Pageable pageable,
            SearchCondition searchCondition,
            @PathVariable("member_id") Long memberId
    ) {
        return scholarshipService.getStudentScholarshipList(pageable, searchCondition, memberId);
    }

    //학생 학생정보시스템 장학내역 리스트 조회
    @GetMapping("/student/scholarship/{member_id}")
    public Header<List<ScholarshipDto>> SchoList(
            @PageableDefault(sort = {"schoId"}) Pageable pageable,
            SearchCondition searchCondition,
            @PathVariable("member_id") Long memberId
    ) {
        return scholarshipService.getStudentScholarshipList(pageable, searchCondition, memberId);
    }
}
