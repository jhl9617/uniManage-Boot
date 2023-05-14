package org.webMonster.uniManageBoot.member.entity;

import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoryCustom {
    List<MemberDepartmentDto> fetchMemberDepartmentData();

    Optional<MemberDepartmentDto> findMemberWithDepartment(long memberId, String memberPwd);

    public List<MemberDepartmentDto> findAllMembersWithDepartment();
}
