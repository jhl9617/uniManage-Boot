package org.webMonster.uniManageBoot.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.member.entity.MemberRepository;
import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;
import org.webMonster.uniManageBoot.member.model.dto.MemberLoginDto;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;
    public MemberDepartmentDto login(MemberLoginDto memberLoginDto) {

        long memberId = memberLoginDto.getMemberId();
        String memberPwd = memberLoginDto.getMemberPwd();

        Optional<MemberDepartmentDto> optionalMemberDepartmentDto =
                memberRepository.findMemberWithDepartment(memberId, memberPwd);

        if (!optionalMemberDepartmentDto.isPresent()) {
            throw new RuntimeException("Member not found");
        }
        MemberDepartmentDto memberDepartmentDto = optionalMemberDepartmentDto.get();
        System.out.println(memberDepartmentDto);
        // Set other properties as needed
        return memberDepartmentDto;
    }


}
