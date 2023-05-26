package org.webMonster.uniManageBoot.member.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface MemberRepository extends JpaRepository<MemberEntity, Long>, MemberRepositoryCustom {

    @Query("SELECT m FROM MemberEntity m WHERE m.memberId = :memberId AND m.memberPwd = :memberPwd")
    MemberEntity findByMemberIdAndMemberPwd(@Param("memberId") long memberId, @Param("memberPwd") String memberPwd);

    @Query("SELECT m FROM MemberEntity m WHERE m.memberId = :memberId")
    MemberEntity findByMemberId(@Param("memberId") long memberId);

    List<MemberEntity> findByMemberId(Long userName);
}
