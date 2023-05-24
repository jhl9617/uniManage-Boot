package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.CancelledLectureDto;

import static org.webMonster.uniManageBoot.member.entity.QMemberEntity.memberEntity;
import static org.webMonster.uniManageBoot.professor.cancelledLecture.entity.QCancelledLectureEntity.cancelledLectureEntity;
import static org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity.lectureEntity;
import static org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity.lectureClassEntity;

import java.util.List;

@Repository
public class CancelledLectureRepositoryCustomImpl extends QuerydslRepositorySupport implements CancelledLectureRepositoryCustom {
    private JPAQueryFactory queryFactory;
    public CancelledLectureRepositoryCustomImpl(JPAQueryFactory queryFactory){
        super(CancelledLectureEntity.class);
        this.queryFactory = queryFactory;
    }

    //페이징처리 + 검색기능
    @Override
    public Page<CancelledLectureEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<CancelledLectureEntity> query = queryFactory
                .selectFrom(cancelledLectureEntity)
                .join(cancelledLectureEntity.lecture, lectureEntity)
                .join(cancelledLectureEntity.member, memberEntity)
                .join(cancelledLectureEntity.lectureClass, lectureClassEntity)
                .where(searchKeyWord(searchCondition.getSk(), searchCondition.getSv()));
        long total = query.stream().count();

        List<CancelledLectureEntity> results = query
                .where(searchKeyWord(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(cancelledLectureEntity.cancelledLectureIdx.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    //(키워드)검색기능 => 강의명, 교수이름
    @Override
    public BooleanExpression searchKeyWord(String sk, String sv) {
       if("lectureId".equals(sk)){
           if(StringUtils.hasLength(sv)){
               return cancelledLectureEntity.lecture.lectureTitle.eq(sv);
           }
       }else if("memberId".equals(sk)){
           if(StringUtils.hasLength(sv)){
               return cancelledLectureEntity.member.name.contains(sv);
           }
       }
       return null;
    }

    @Override
    public List<CancelledLectureEntity> findAllBySearchConditionByMemberId(Pageable pageable, SearchCondition searchCondition) {
        return null;
    }

    //휴강게시글 리스트 전체 조회(교직원용)
//    @Override
//    public List<CancelledLectureDto> findAllBySearchConditionByMemberId(Pageable pageable, SearchCondition searchCondition) {
//        return queryFactory
//                .select(Projections.bean(
//                        CancelledLectureDto.class,
//                        cancelledLectureEntity.cancelledLectureIdx,
//                        lectureEntity.lectureId,
//                        memberEntity.memberId,
//                        lectureClassEntity.lectureRoomCode,
//                        cancelledLectureEntity.attendanceDay,
//                        cancelledLectureEntity.supplyDate,
//                        cancelledLectureEntity.reason,
//                        cancelledLectureEntity.cancelledFile,
//                        cancelledLectureEntity.cancelledRename,
//                        cancelledLectureEntity.cancelledApply))
//                .from(cancelledLectureEntity)
//                .join(cancelledLectureEntity.lecture, lectureEntity)
//                .join(cancelledLectureEntity.member, memberEntity)
//                .join(cancelledLectureEntity.lectureClass, lectureClassEntity)
//                .fetch();
//    }


    //휴강게시물 리스트 id로 조회(교수용)
    public List<CancelledLectureDto> findAllBySearchConditionByMemberId(Long memberId) {
        return queryFactory
                .select(Projections.bean(
                        CancelledLectureDto.class,
                        cancelledLectureEntity.cancelledLectureIdx,
                        lectureEntity.lectureId,
                        memberEntity.memberId,
                        lectureClassEntity.lectureRoomCode,
                        cancelledLectureEntity.attendanceDay,
                        cancelledLectureEntity.supplyDate,
                        cancelledLectureEntity.reason,
                        cancelledLectureEntity.cancelledFile,
                        cancelledLectureEntity.cancelledRename,
                        cancelledLectureEntity.cancelledApply))
                .from(cancelledLectureEntity)
                .join(cancelledLectureEntity.lecture, lectureEntity)
                .join(cancelledLectureEntity.member, memberEntity)
                .join(cancelledLectureEntity.lectureClass, lectureClassEntity)
                .where(cancelledLectureEntity.memberId.eq(memberId))
                .fetch();
    }
}