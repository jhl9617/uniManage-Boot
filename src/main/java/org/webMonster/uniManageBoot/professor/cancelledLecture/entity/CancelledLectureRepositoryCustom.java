package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.CancelledLectureDto;

import java.util.Optional;

public interface CancelledLectureRepositoryCustom {

    //휴강게시글 조회
    Optional<CancelledLectureDto> findCancelledLectureList(long memberId);
}
