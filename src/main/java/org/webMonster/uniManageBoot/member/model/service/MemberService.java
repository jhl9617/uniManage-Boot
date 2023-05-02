package org.webMonster.uniManageBoot.member.model.service;

import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
    public MemberEntity login(MemberEntity memberEntity) {
        memberEntity.setMember_id(161350);
        memberEntity.setMember_pwd("1234");
        memberEntity.setName("홍길동");
        memberEntity.setEmail("abc@d.com");
        memberEntity.setAuth(3);    //3은 재학생, 필요시 변경  //권한구분:교수 1, 교직원 2,재학생 3, 졸업생 4, 휴학생 5
        return memberEntity;
    }

}
