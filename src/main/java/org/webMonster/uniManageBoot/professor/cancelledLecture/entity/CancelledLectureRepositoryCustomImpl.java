package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.webMonster.uniManageBoot.member.entity.QMemberEntity;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.CancelledLectureDto;
import org.webMonster.uniManageBoot.professor.lecture.entity.QLectureEntity;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.QLectureClassEntity;


import java.util.Optional;

public class CancelledLectureRepositoryCustomImpl extends QuerydslRepositorySupport implements CancelledLectureRepositoryCustom {
    private JPAQueryFactory queryFactory;

    public CancelledLectureRepositoryCustomImpl(JPAQueryFactory queryFactory){
        super(CancelledLectureEntity.class);
        this.queryFactory = queryFactory;
    }

    //아이디, 강의번호
    @Override
    public Optional<CancelledLectureDto> findCancelledLectureList(long memberId){
        QCancelledLectureEntity cancelledLectureEntity = QCancelledLectureEntity.cancelledLectureEntity;
        QLectureEntity lectureEntity = QLectureEntity.lectureEntity;
        QMemberEntity memberEntity = QMemberEntity.memberEntity;
        QLectureClassEntity lectureClassEntity = QLectureClassEntity.lectureClassEntity;

        return Optional.ofNullable(
                queryFactory
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
                        .fetchOne()
                        );
    }
}