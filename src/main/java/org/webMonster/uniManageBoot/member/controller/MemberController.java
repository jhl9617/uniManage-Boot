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
import java.util.Map;

@Slf4j
@CrossOrigin
@RestController
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @PostMapping("/getProfile")
    public void getProfile(@RequestBody Map<String, String> body, HttpSession session) {
        String memberIdStr = body.get("memberId");
        long memberId = Long.parseLong(memberIdStr);

        MemberLoginDto memberLoginDto = new MemberLoginDto();
        memberLoginDto.setMemberId(memberId);
        MemberDepartmentDto memberDepartmentDto = memberService.getProfile(memberLoginDto);
        session.setAttribute("loginMember", memberDepartmentDto);
    }


    //세션이 있는지 확인
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

    @PostMapping("/insert")
    public ResponseEntity<MemberEntity> insert() {
        MemberEntity memberEntity = memberService.insert();
        return ResponseEntity.ok(memberEntity);
    }

    //로그아웃 처리 세션 삭제
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        System.out.println("\n\n세션 삭제 완료\n\n");
        session.invalidate();
    }


}
