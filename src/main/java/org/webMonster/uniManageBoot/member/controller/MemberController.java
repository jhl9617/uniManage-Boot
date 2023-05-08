package org.webMonster.uniManageBoot.member.controller;

import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.member.model.dto.MemberDto;
import org.webMonster.uniManageBoot.member.model.dto.MemberLoginDto;
import org.webMonster.uniManageBoot.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
        MemberDto member = memberService.login(memberLoginDto);
        session.setAttribute("loginMember", member);
        String path = null;
        if (member.getAuth() == 3 || member.getAuth() == 4 || member.getAuth() == 5) {   //학생
            path = "/student";
        } else if (member.getAuth() == 1) {                 //교수
            path = "/prof/main";
        } else if (member.getAuth() == 2) {                 //교직원
            path = "/admin";
        }
        return ResponseEntity.ok(path);
        /*if (member != null) {
            session.setAttribute("loginMember", member);
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }*/
    }
    //세션에 있는지 확인
    @GetMapping("/sessionCheck")
    public ResponseEntity<MemberEntity> getSession(HttpSession session) {
        MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");
        if (loginMember != null) {
            return ResponseEntity.ok(loginMember);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
