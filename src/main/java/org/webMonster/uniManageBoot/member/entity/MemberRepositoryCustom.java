package org.webMonster.uniManageBoot.member.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepositoryCustom {
    List<MemberDepartmentDto> fetchMemberDepartmentData();

    Optional<MemberDepartmentDto> findMemberWithDepartment(long memberId, String memberPwd);

//    List<MemberDepartmentDto> findAllMembersWithDepartment();

    //교직원 학생관리 리스트 출력용
    Page<MemberEntity> findAllBySearchConditionsAndAuth(Pageable pageable, SearchCondition searchCondition);

    //교직원 교수관리 리스트 출력용
    Page<MemberEntity> findAllBySearchConditionAndAuth(Pageable pageable, SearchCondition searchCondition);

    //교직원 학생/교수관리 리스트에서 검색용
    BooleanExpression searchKeywords(String sk, String sv);
}
