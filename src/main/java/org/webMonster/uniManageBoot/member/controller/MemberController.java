package org.webMonster.uniManageBoot.member.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
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

    @GetMapping("/prof/info")
    public MemberDepartmentDto professorInfo(HttpSession session) {
        MemberDepartmentDto loginMember = (MemberDepartmentDto) session.getAttribute("loginMember");
        return loginMember;
    }

    //교수 개인정보 페이지 수정
    @PatchMapping("/prof/info")
    public MemberEntity update(@RequestBody MemberDepartmentDto memberDepartmentDto, HttpSession session){
        session.setAttribute("loginMember", memberDepartmentDto);
        return memberService.update(memberDepartmentDto);

    }
}
