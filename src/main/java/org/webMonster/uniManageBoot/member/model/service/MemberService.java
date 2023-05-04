package org.webMonster.uniManageBoot.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.member.entity.MemberRepository;
import org.webMonster.uniManageBoot.member.model.dto.MemberLoginDto;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;
    public MemberEntity login(MemberLoginDto memberLoginDto) {
        /*memberEntity.setMember_id(161350);
        memberEntity.setMember_pwd("1234");
        memberEntity.setName("홍길동");
        memberEntity.setEmail("abc@d.com");
        memberEntity.setAuth(3);    //3은 재학생, 필요시 변경  //권한구분:교수 1, 교직원 2,재학생 3, 졸업생 4, 휴학생 5
        return memberEntity;*/
        String memberId = memberLoginDto.getMember_id();
        String memberPwd = memberLoginDto.getMember_pwd();

        MemberEntity member = memberRepository.findByMemberIdAndMemberPwd(memberId, memberPwd);

        if (member == null) {
            // Handle the case when the member is not found, e.g., log a warning, return a default value, etc.
            System.out.println("No member found with the given member_id and member_pwd.");
            log.info("널이야");
            return null;
        }
        
        return member;
    }


}
