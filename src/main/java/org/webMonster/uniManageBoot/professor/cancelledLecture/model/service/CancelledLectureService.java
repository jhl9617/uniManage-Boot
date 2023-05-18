package org.webMonster.uniManageBoot.professor.cancelledLecture.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureEntity;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureRepository;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.CancelledLectureDto;

@Slf4j
@RequiredArgsConstructor
@Service
public class CancelledLectureService {

    @Autowired
    private CancelledLectureRepository cancelledLectureRepository;

    //게시글 등록
    public CancelledLectureEntity create(CancelledLectureDto cancelledLectureDto) {
        CancelledLectureEntity entity = CancelledLectureEntity.builder()
                .lectureId(cancelledLectureDto.getLectureId())
                .memberId(cancelledLectureDto.getMemberId())
                .cancelledRename(cancelledLectureDto.getCancelledRename())
                .attendanceDay(cancelledLectureDto.getAttendanceDay())
                .supplyDate(cancelledLectureDto.getSupplyDate())
                .reason(cancelledLectureDto.getReason())
                .cancelledFile(cancelledLectureDto.getCancelledFile())
                .cancelledRename(cancelledLectureDto.getCancelledRename())
                .cancelledApply(cancelledLectureDto.getCancelledApply())
                .build();
        return cancelledLectureRepository.save(entity);
    }
}
