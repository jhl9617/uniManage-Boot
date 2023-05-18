package org.webMonster.uniManageBoot.member.model.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.member.entity.MemberRepository;
import org.webMonster.uniManageBoot.member.entity.MemberRepositoryCustom;
import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;
import org.webMonster.uniManageBoot.member.model.dto.MemberLoginDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberRepositoryCustom memberRepositoryCustom;

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

    //교직원 학생관리 리스트 조회
    public Header<List<MemberDepartmentDto>> getStudentList(Pageable pageable, SearchCondition searchCondition) {
        List<MemberDepartmentDto> dtos = new ArrayList<>();

        Page<MemberEntity> studentDepartmentEntities = memberRepositoryCustom.findAllBySearchConditionsAndAuth(pageable, searchCondition);
        for (MemberEntity entity : studentDepartmentEntities) {
            MemberDepartmentDto dto = MemberDepartmentDto.builder()
                    .name(entity.getName())
                    .memberId(entity.getMemberId())
                    .departmentName(entity.getDepartment().getDepartmentName())
                    .build();
            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) studentDepartmentEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );
        log.info("dtos:" + dtos);

        return Header.OK(dtos, pagination);
    }
}
