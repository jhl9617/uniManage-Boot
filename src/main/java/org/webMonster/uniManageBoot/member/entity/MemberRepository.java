package org.webMonster.uniManageBoot.member.entity;

import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;

import java.util.List;


public interface MemberRepository extends JpaRepository<MemberEntity, Long>, MemberRepositoryCustom {
    
    
    @Query("SELECT m FROM MemberEntity m WHERE m.memberId = :memberId AND m.memberPwd = :memberPwd")
    MemberEntity findByMemberIdAndMemberPwd(@Param("memberId") long memberId, @Param("memberPwd") String memberPwd);


    List<MemberEntity> findByMemberId(Long userName);
}
