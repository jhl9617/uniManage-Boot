package org.webMonster.uniManageBoot.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.webMonster.uniManageBoot.admin.scholarship.entity.ScholarshipEntity;
import org.webMonster.uniManageBoot.admin.scholarship.model.dto.ScholarshipDto;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;
import org.webMonster.uniManageBoot.member.model.dto.MemberDto;
import org.webMonster.uniManageBoot.member.model.dto.MemberLoginDto;
import org.webMonster.uniManageBoot.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;
import org.webMonster.uniManageBoot.professor.lectureClass.model.dto.LectureClassDto;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/onLogin")
    public ResponseEntity<String> login(@RequestBody MemberLoginDto memberLoginDto, HttpSession session) {
        MemberDepartmentDto memberDepartmentDto = memberService.login(memberLoginDto);
        session.setAttribute("loginMember", memberDepartmentDto);
        String path = null;
        if (memberDepartmentDto.getAuth() == 3 || memberDepartmentDto.getAuth() == 4 || memberDepartmentDto.getAuth() == 5) {   //학생
            path = "/student";
        } else if (memberDepartmentDto.getAuth() == 1) {                 //교수
            path = "/prof/main";
        } else if (memberDepartmentDto.getAuth() == 2) {                 //교직원
            path = "/admin";
        }
        return ResponseEntity.ok(path);
    }

    //세션에 있는지 확인
    @GetMapping("/sessionCheck")
    public ResponseEntity<MemberDepartmentDto> getSession(HttpSession session) {
        MemberDepartmentDto loginMember = (MemberDepartmentDto) session.getAttribute("loginMember");
        if (loginMember != null) {
            return ResponseEntity.ok(loginMember);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    //교직원 학생관리 리스트 조회
   @GetMapping("/admin/manage/student")
    public Header<List<MemberDepartmentDto>> studentList(
            @PageableDefault(sort = {"memberIdx"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return memberService.getStudentList(pageable, searchCondition);
    }

    //교직원 학생관리 상세보기글 조회
    @GetMapping("/admin/manage/student/{id}")
    public MemberDepartmentDto getStudent(@PathVariable Long id) { return memberService.getMember(id); }

    //교직원 학생관리 추가하기
    @PostMapping("/admin/manage/student")
    public MemberEntity createStudent(@RequestBody MemberDto memberDto) { return memberService.create(memberDto); }

    //교직원 학생관리 수정하기
    @PatchMapping("/admin/manage/student")
    public MemberEntity update(@RequestBody MemberDto memberDto){ return memberService.update(memberDto); }

    //교직원 학생관리 삭제하기
    @DeleteMapping("/admin/manage/student/{id}")
    public void delete(@PathVariable Long id) { memberService.delete(id); }

    //교직원 교수관리 리스트 조회
    @GetMapping("/admin/manage/professor")
    public Header<List<MemberDepartmentDto>> professorList(
            @PageableDefault(sort = {"memberIdx"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return memberService.getProfessorList(pageable, searchCondition);
    }

    //교직원 교수관리 상세보기글 조회
    @GetMapping("/admin/manage/professor/{id}")
    public MemberDepartmentDto getProfessor(@PathVariable Long id) { return memberService.getMember(id); }

    //교직원 교수관리 추가하기
    @PostMapping("/admin/manage/professor")
    public MemberEntity createProfessor(@RequestBody MemberDto memberDto) { return memberService.create(memberDto); }


}
