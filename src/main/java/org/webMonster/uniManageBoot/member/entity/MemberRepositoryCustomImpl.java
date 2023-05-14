package org.webMonster.uniManageBoot.member.entity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;



import static org.webMonster.uniManageBoot.member.entity.QMemberEntity.memberEntity;
import static org.webMonster.uniManageBoot.student.department.entity.QDepartmentEntity.departmentEntity;

import java.util.List;
import java.util.Optional;

public class MemberRepositoryCustomImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MemberRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(MemberEntity.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<MemberDepartmentDto> fetchMemberDepartmentData() {
        return queryFactory
                .select(Projections.constructor(MemberDepartmentDto.class, memberEntity.name, departmentEntity.departmentName))
                .from(memberEntity)
                .join(memberEntity.department, departmentEntity)
                .fetch();
    }

    @Override
    public Optional<MemberDepartmentDto> findMemberWithDepartment(long memberId, String memberPwd) {
        return Optional.ofNullable(
                queryFactory
                        .select(Projections.bean(
                                MemberDepartmentDto.class,
                                memberEntity.memberIdx,
                                memberEntity.memberId,
                                memberEntity.name,
                                memberEntity.memberPwd,
                                memberEntity.email,
                                memberEntity.phone,
                                memberEntity.address1,
                                memberEntity.address2,
                                memberEntity.departmentId,
                                memberEntity.grade,
                                memberEntity.birthday,
                                memberEntity.postcode,
                                memberEntity.auth,
                                memberEntity.address1,
                                memberEntity.address2,
                                departmentEntity.departmentName))
                        .from(memberEntity)
                        .join(memberEntity.department, departmentEntity)    //memberEntity.department를 기반으로 조인
                        .where(memberEntity.memberId.eq(memberId).and(memberEntity.memberPwd.eq(memberPwd)))
                        .fetchOne() //단일결과 가져오기, 2개 이상이면 예외
        );
    }

    @Override
    public List<MemberDepartmentDto> findAllMembersWithDepartment() {
        return queryFactory
                .select(Projections.bean(
                        MemberDepartmentDto.class,
                        memberEntity.memberIdx,
                        memberEntity.memberId,
                        memberEntity.name,
                        memberEntity.memberPwd,
                        memberEntity.email,
                        memberEntity.phone,
                        memberEntity.address1,
                        memberEntity.address2,
                        memberEntity.departmentId,
                        memberEntity.grade,
                        memberEntity.birthday,
                        memberEntity.postcode,
                        memberEntity.auth,
                        memberEntity.address1,
                        memberEntity.address2,
                        departmentEntity.departmentName))
                .from(memberEntity)
                .join(memberEntity.department, departmentEntity)
                .fetch();
    }



}
