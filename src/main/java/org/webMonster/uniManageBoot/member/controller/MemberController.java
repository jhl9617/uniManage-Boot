package org.webMonster.uniManageBoot.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.webMonster.uniManageBoot.admin.notice.model.service.NoticeService;
import org.webMonster.uniManageBoot.admin.schedule.model.service.ScheduleService;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;

import org.webMonster.uniManageBoot.member.entity.MemberRepository;
import org.webMonster.uniManageBoot.member.model.dto.*;

import org.webMonster.uniManageBoot.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class MemberController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;

    private final NoticeService noticeService;

    private final ScheduleService scheduleService;


    @PostMapping("/getProfile")
    public void getProfile(@RequestBody Map<String, String> body, HttpSession session) {
        String memberIdStr = body.get("memberId");
        long memberId = Long.parseLong(memberIdStr);

        MemberLoginDto memberLoginDto = new MemberLoginDto();
        memberLoginDto.setMemberId(memberId);
        MemberDepartmentDto memberDepartmentDto = memberService.getProfile(memberLoginDto);
        session.setAttribute("loginMember", memberDepartmentDto);
    }
    
    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
            session.invalidate(); // 세션 종료
            return ResponseEntity.ok("/"); // 로그아웃 후 이동할 경로 반환

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

    //교직원 학생관리 상세보기글 조회
    @GetMapping("/admin/manage/student/{id}")
    public MemberDepartmentDto getStudent(@PathVariable Long id) { return memberService.getMember(id); }

    //교직원 학생관리 추가하기
    @PostMapping("/admin/manage/student")
    public MemberEntity createStudent(@RequestBody MemberDto memberDto) { return memberService.create(memberDto); }

    //교직원 학생관리 수정하기
    @PatchMapping("/admin/manage/student")
//    public MemberEntity updateStudent(@RequestBody MemberDto memberDto){return memberService.update(memberDto);}
    public MemberDto updateStudent(@RequestBody MemberDto memberDto) {
        MemberEntity entity = memberService.update(memberDto);
        return MemberDto.fromEntity(entity);
    }

    //교직원 학생관리 삭제하기
    @DeleteMapping("/admin/manage/student/{id}")
    public void deleteStudent(@PathVariable Long id) { memberService.delete(id); }

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

    //교직원 교수관리 수정하기
    @PatchMapping("/admin/manage/professor")
    public MemberDto updateProfessor(@RequestBody MemberDto memberDto) {
        MemberEntity entity = memberService.update(memberDto);
        return MemberDto.fromEntity(entity);
    }

    //교직원 교수관리 삭제하기
    @DeleteMapping("/admin/manage/professor/{id}")
    public void deleteProfessor(@PathVariable Long id) { memberService.delete(id); }

    //학생정보시스템 메인페이지에서 공지사항/학사일정 4개 리스트 조회
    @GetMapping("/student")
    public StudentMainDto getStudentMain(){
        StudentMainDto response = new StudentMainDto();
        response.setNoticeDto(noticeService.getNoticeList());
        response.setScheduleDto(scheduleService.getScheduleList());

        return response;
    }

    //교수 메인페이지에서 공지사항 4개 리스트 조회
    @GetMapping("/prof/main")
    public ProfessorMainDto getProfMain(){
        ProfessorMainDto response = new ProfessorMainDto();
        response.setNoticeDto(noticeService.getNoticeList());
        response.setScheduleDto(scheduleService.getScheduleList());

        return response;
    }

    @GetMapping("/prof/info")
    public MemberDepartmentDto professorInfo(HttpSession session) {
        MemberDepartmentDto loginMember = (MemberDepartmentDto) session.getAttribute("loginMember");
        return loginMember;
    }

    //교수 개인정보 페이지 수정
    @PostMapping("/prof/info")
    public MemberEntity update(@RequestBody MemberDepartmentDto memberDepartmentDto, HttpSession session){
        MemberDepartmentDto sessionMember = (MemberDepartmentDto) session.getAttribute("loginMember");
        sessionMember.setPhone(memberDepartmentDto.getPhone());
        sessionMember.setPostcode(memberDepartmentDto.getPostcode());
        sessionMember.setAddress1(memberDepartmentDto.getAddress1());
        sessionMember.setAddress2(memberDepartmentDto.getAddress2());
        session.setAttribute("loginMember", sessionMember);
        return memberService.update(sessionMember);
    }
    @PostMapping("/insert")
    public ResponseEntity<MemberEntity> insert() {
        MemberEntity memberEntity = memberService.insert();
        return ResponseEntity.ok(memberEntity);
    }

    /*//로그아웃 처리 세션 삭제
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        System.out.println("\n\n세션 삭제 완료\n\n");
        session.invalidate();
    }*/

    //학생 마이페이지 개인정보 조회
    @GetMapping("/student/mypage")
    public MemberDepartmentDto studentMypage(HttpSession session) {
        MemberDepartmentDto loginMember = (MemberDepartmentDto) session.getAttribute("loginMember");
        return loginMember;
    }


    //학생 마이페이지 개인정보 수정
    @PatchMapping("/student/mypage")
    public MemberEntity updateStudentMypage(@RequestBody MemberDepartmentDto memberDepartmentDto, HttpSession session) {
        MemberDepartmentDto sessionMember = (MemberDepartmentDto) session.getAttribute("loginMember");
        sessionMember.setPhone(memberDepartmentDto.getPhone());
        sessionMember.setPostcode(memberDepartmentDto.getPostcode());
        sessionMember.setAddress1(memberDepartmentDto.getAddress1());
        sessionMember.setAddress2(memberDepartmentDto.getAddress2());
        session.setAttribute("loginMember", sessionMember);

        // 수정된 정보를 MemberEntity로 변환하여 저장
        MemberEntity entity = memberRepository.findById(sessionMember.getMemberIdx()).orElse(null);
        if (entity != null) {
            entity.setPhone(sessionMember.getPhone());
            entity.setPostcode(sessionMember.getPostcode());
            entity.setAddress1(sessionMember.getAddress1());
            entity.setAddress2(sessionMember.getAddress2());
            return memberRepository.save(entity);
        }
        return null;
    }




}
