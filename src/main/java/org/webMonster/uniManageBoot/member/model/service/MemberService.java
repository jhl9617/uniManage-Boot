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
import org.webMonster.uniManageBoot.member.model.dto.MemberDto;
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
                    .memberIdx(entity.getMemberIdx())
                    .name(entity.getName())
                    .memberId(entity.getMemberId())
                    .memberPwd(entity.getMemberPwd())
                    .departmentId(entity.getDepartmentId())
                    .grade(entity.getGrade())
                    .birthday(entity.getBirthday())
                    .phone(entity.getPhone())
                    .email(entity.getEmail())
                    .postcode(entity.getPostcode())
                    .address1(entity.getAddress1())
                    .address2(entity.getAddress2())
                    .auth(entity.getAuth())
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

    // 교직원 학생/교수관리 상세보기 조회
    public MemberDepartmentDto getMember(Long id) {
        MemberEntity entity = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
        return MemberDepartmentDto.builder()
                .memberIdx(entity.getMemberIdx())
                .memberId(entity.getMemberId())
                .memberPwd(entity.getMemberPwd())
                .name(entity.getName())
                .departmentId(entity.getDepartmentId())
                .grade(entity.getGrade())
                .birthday(entity.getBirthday())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .postcode(entity.getPostcode())
                .address1(entity.getAddress1())
                .address2(entity.getAddress2())
                .auth(entity.getAuth())
                .departmentName(entity.getDepartment().getDepartmentName())
                .build();
    }

    //교직원 학생/교수관리 추가
    public MemberEntity create(MemberDto memberDto) {
        MemberEntity entity = MemberEntity.builder()
                .memberIdx(memberDto.getMemberIdx())
                .memberId(memberDto.getMemberId())
                .memberPwd(memberDto.getMemberPwd())
                .name(memberDto.getName())
                .departmentId(memberDto.getDepartmentId())
                .grade(memberDto.getGrade())
                .birthday(memberDto.getBirthday())
                .phone(memberDto.getPhone())
                .email(memberDto.getEmail())
                .postcode(memberDto.getPostcode())
                .address1(memberDto.getAddress1())
                .address2(memberDto.getAddress2())
                .auth(memberDto.getAuth())
                .build();
        return memberRepository.save(entity);
    }

    //교직원 학생/교수관리 수정
    public MemberEntity update(MemberDto memberDto) {
        MemberEntity entity = memberRepository.findById(memberDto.getMemberIdx()).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
        entity.setMemberIdx(memberDto.getMemberIdx());
        entity.setMemberId(memberDto.getMemberId());
        entity.setMemberPwd(memberDto.getMemberPwd());
        entity.setName(memberDto.getName());
        entity.setDepartmentId(memberDto.getDepartmentId());
        entity.setGrade(memberDto.getGrade());
        entity.setBirthday(memberDto.getBirthday());
        entity.setPhone(memberDto.getPhone());
        entity.setEmail(memberDto.getEmail());
        entity.setPostcode(memberDto.getPostcode());
        entity.setAddress1(memberDto.getAddress1());
        entity.setAddress2(memberDto.getAddress2());
        entity.setAuth(memberDto.getAuth());
        return memberRepository.save(entity);
    }

    //교직원 학생/교수관리 삭제
    public void delete(Long id) {
        MemberEntity entity = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
        memberRepository.delete(entity);
    }

    //교직원 교수관리 리스트 조회
    public Header<List<MemberDepartmentDto>> getProfessorList(Pageable pageable, SearchCondition searchCondition) {
        List<MemberDepartmentDto> dtos = new ArrayList<>();

        Page<MemberEntity> studentDepartmentEntities = memberRepositoryCustom.findAllBySearchConditionAndAuth(pageable, searchCondition);
        for (MemberEntity entity : studentDepartmentEntities) {
            MemberDepartmentDto dto = MemberDepartmentDto.builder()
                    .memberIdx(entity.getMemberIdx())
                    .name(entity.getName())
                    .memberId(entity.getMemberId())
                    .memberPwd(entity.getMemberPwd())
                    .departmentId(entity.getDepartmentId())
                    .birthday(entity.getBirthday())
                    .phone(entity.getPhone())
                    .email(entity.getEmail())
                    .postcode(entity.getPostcode())
                    .address1(entity.getAddress1())
                    .address2(entity.getAddress2())
                    .auth(entity.getAuth())
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
