package org.webMonster.uniManageBoot.member.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoryCustom {
    List<MemberDepartmentDto> fetchMemberDepartmentData();

    Optional<MemberDepartmentDto> findMemberWithDepartment(long memberId, String memberPwd);

    List<MemberDepartmentDto> findAllMembersWithDepartment();

    //교직원 학생관리 리스트 출력용
    Page<MemberEntity> findAllBySearchConditionsAndAuth(Pageable pageable, SearchCondition searchCondition);

}
