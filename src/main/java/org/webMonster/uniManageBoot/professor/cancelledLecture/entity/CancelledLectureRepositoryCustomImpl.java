package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.entity.QMemberEntity;

import java.util.List;

import static org.webMonster.uniManageBoot.professor.cancelledLecture.entity.QCancelledLectureEntity.cancelledLectureEntity;
import static org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity.lectureEntity;

@Repository
public class CancelledLectureRepositoryCustomImpl extends QuerydslRepositorySupport implements CancelledLectureRepositoryCustom {
    private JPAQueryFactory queryFactory;

    public CancelledLectureRepositoryCustomImpl(JPAQueryFactory queryFactory) {
        super(CancelledLectureEntity.class);
        this.queryFactory = queryFactory;
    }

    //교수전체 휴강신청 리스트 조회(교직원용)
    @Override
    public Page<CancelledLectureEntity> findAllBySearchConditionAndStatus(Pageable pageable, SearchCondition searchCondition) {
        JPAQuery<CancelledLectureEntity> query = queryFactory.selectFrom(cancelledLectureEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));
        long total = query.fetchCount();
        List<CancelledLectureEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(cancelledLectureEntity.cancelledLectureIdx.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    //교수 휴강신청 리스트 조회(교수용)
    @Override
    public Page<CancelledLectureEntity> findAllBySearchConditionAndStatusByMemberId(Pageable pageable, SearchCondition searchCondition, Long memberId) {
        JPAQuery<CancelledLectureEntity> query = queryFactory.selectFrom(cancelledLectureEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .where(cancelledLectureEntity.memberId.eq(memberId));
        long total = query.fetchCount();
        List<CancelledLectureEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(cancelledLectureEntity.lectureId.desc())
                .fetch();
        return new PageImpl<>(results, pageable, total);
    }

    //검색용(교직원)
    @Override
    public BooleanExpression searchKeywords(String sk, String sv) {
        if ("reason".equals(sk)) {                //휴강사유로 검색
            if (StringUtils.hasLength(sv)) {
                return cancelledLectureEntity.reason.contains(sv);
            }
        } else if ("cancelledFile".equals(sk)) {  //파일명으로 검색
            if (StringUtils.hasLength(sv)) {
                return cancelledLectureEntity.cancelledFile.contains(sv);
            }
        } else if ("name".equals(sk)) {     //교수명으로 검색
            if (StringUtils.hasLength(sv)) {
                QMemberEntity memberEntity = QMemberEntity.memberEntity;
                return lectureEntity.memberId.in(
                        JPAExpressions.select(memberEntity)
                                .from(memberEntity)
                                .where(memberEntity.name.contains(sv))
                                .select(memberEntity.memberId)
                );
            }
        }
        return null;
    }
}