package org.webMonster.uniManageBoot.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.member.entity.MemberRepository;
import org.webMonster.uniManageBoot.member.model.dto.MemberDto;
import org.webMonster.uniManageBoot.member.model.dto.MemberLoginDto;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;
    public MemberDto login(MemberLoginDto memberLoginDto) {
        /*memberEntity.setMember_id(161350);
        memberEntity.setMember_pwd("1234");
        memberEntity.setName("홍길동");
        memberEntity.setEmail("abc@d.com");
        memberEntity.setAuth(3);    //3은 재학생, 필요시 변경  //권한구분:교수 1, 교직원 2,재학생 3, 졸업생 4, 휴학생 5
        return memberEntity;*/
        long memberId = memberLoginDto.getMember_id();
        String memberPwd = memberLoginDto.getMember_pwd();

        MemberEntity memberEntity = memberRepository.findByMemberIdAndMemberPwd(memberId, memberPwd);
        // Convert MemberEntity to MemberDto

        MemberDto memberDto = MemberDto.fromEntity(memberEntity);
        // Set other properties as needed



        return memberDto;
    }


}
