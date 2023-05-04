package org.webMonster.uniManageBoot.member.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    @Query("SELECT m FROM MemberEntity m WHERE m.member_id = :member_id AND m.member_pwd = :member_pwd")
    MemberEntity findByMemberIdAndMemberPwd(@Param("member_id") String member_id, @Param("member_pwd") String member_pwd);

}
