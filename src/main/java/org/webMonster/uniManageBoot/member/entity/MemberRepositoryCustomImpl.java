package org.webMonster.uniManageBoot.member.entity;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.model.dto.MemberDepartmentDto;
import org.webMonster.uniManageBoot.student.department.entity.QDepartmentEntity;

import static org.webMonster.uniManageBoot.member.entity.QMemberEntity.memberEntity;
import static org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity.lectureEntity;
import static org.webMonster.uniManageBoot.student.department.entity.QDepartmentEntity.departmentEntity;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
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

    //교직원 학생관리 리스트 출력
    public Page<MemberEntity> findAllBySearchConditionsAndAuth(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<MemberEntity> query = queryFactory.selectFrom(memberEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(memberEntity.auth.in(3,4,5));

        long total = query.fetchCount();

        List<MemberEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(memberEntity.memberIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }


    //교직원 학생관리 리스트에서 검색용
    public BooleanExpression searchKeywords(String sk, String sv) {
        if("name".equals(sk)) {   //학생명으로 검색
            if(StringUtils.hasLength(sv)) {
                return memberEntity.name.contains(sv);
            }
        } else if ("member_id".equals(sk)) {   //학생 번호로 검색
            if(StringUtils.hasLength(sv)) {
                return memberEntity.memberId.stringValue().contains(sv);
            }
        }  else if ("department_name".equals(sk)) {   //학과명으로 검색
            if (StringUtils.hasLength(sv)) {
                // 다른 테이블의 department_name 컬럼을 조인하여 검색
                QDepartmentEntity departmentEntity = QDepartmentEntity.departmentEntity;
                return departmentEntity.departmentId.in(
                        JPAExpressions.select(departmentEntity)
                                .from(departmentEntity)
                                .where(departmentEntity.departmentName.contains(sv))
                                .select(departmentEntity.departmentId)
                );
            }
        }

        return null;
    }

}
