package org.webMonster.uniManageBoot.professor.cancelledLecture.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureEntity;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureRepository;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureRepositoryCustomImpl;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.CancelledLectureDto;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.ApplyDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CancelledLectureService {

    @Autowired
    private CancelledLectureRepository cancelledLectureRepository;

    @Autowired
    private CancelledLectureRepositoryCustomImpl cancelledLectureRepositoryCustom;


//    휴강신청 리스트 전체조회(교직원용)
//    public Header<List<CancelledLectureDto>> getCancelledLectureList(Pageable pageable, SearchCondition searchCondition, HttpSession session) {
//        List<CancelledLectureDto> dtos = new ArrayList<>();
//        Page<CancelledLectureEntity> cancelledLectureEntities = cancelledLectureRepositoryCustom.findAllBySearchCondition(pageable, searchCondition, session);
//
//        for (CancelledLectureEntity entity : cancelledLectureEntities) {
//            CancelledLectureDto dto = CancelledLectureDto.builder()
//                    .cancelledLectureIdx(entity.getCancelledLectureIdx())
//                    .lectureId(entity.getLectureId())
//                    .memberId(entity.getMemberId())
//                    .attendanceDay(entity.getAttendanceDay())
//                    .supplyDate(entity.getSupplyDate())
//                    .reason(entity.getReason())
//                    .cancelledFile(entity.getCancelledFile())
//                    .cancelledRename(entity.getCancelledRename())
//                    .cancelledApply(entity.getCancelledApply())
//                    .build();
//            dtos.add(dto);
//        }
//
//      Pagination pagination = new Pagination(
//              (int) cancelledLectureEntities.getTotalElements(),
//              pageable.getPageNumber() + 1,
//              pageable.getPageSize(),
//              10
//      );
//        return Header.OK(dtos, pagination);
//    }


    //본인이 작성한 휴강신청 리스트 조회(교수용)
    public Header<List<CancelledLectureDto>> getCancelledLectureList(Pageable pageable, SearchCondition searchCondition, long memberId) {
        List<CancelledLectureDto> dtos = new ArrayList<>();

        Page<CancelledLectureEntity> cancelledLectureEntities = cancelledLectureRepositoryCustom.findAllBySearchConditionByMemberId(pageable, searchCondition, memberId);
        if(cancelledLectureEntities != null)
        for(CancelledLectureEntity entity : cancelledLectureEntities){
            CancelledLectureDto dto = CancelledLectureDto.builder()
                    .cancelledLectureIdx(entity.getCancelledLectureIdx())
                    .lectureId(entity.getLecture().getLectureId())
                    .memberId(entity.getMember().getMemberId())
                    .lectureRoomCode(entity.getLectureClass().getLectureRoomCode())
                    .attendanceDay(entity.getAttendanceDay())
                    .supplyDate(entity.getSupplyDate())
                    .reason(entity.getReason())
                    .cancelledFile(entity.getCancelledFile())
                    .cancelledFileRename(entity.getCancelledFileRename())
                    .cancelledApply(entity.getCancelledApply())
                    .build();
            dtos.add(dto);
        }
        Pagination pagination = new Pagination(
                (int) cancelledLectureEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                ,10
        );
        log.info("dtos:" + dtos);
        return Header.OK(dtos, pagination);
    }


    //휴강게시글 작성
    public CancelledLectureEntity create(CancelledLectureDto cancelledLectureDto) {
        CancelledLectureEntity entity = CancelledLectureEntity.builder()
                .lectureId(cancelledLectureDto.getLectureId())
                .memberId(cancelledLectureDto.getMemberId())
                .lectureRoomCode(cancelledLectureDto.getLectureRoomCode())
                .attendanceDay(cancelledLectureDto.getAttendanceDay())
                .supplyDate(cancelledLectureDto.getSupplyDate())
                .reason(cancelledLectureDto.getReason())
                .cancelledApply(cancelledLectureDto.getCancelledApply())
                .build();
        return cancelledLectureRepository.save(entity);
    }


    //휴강게시글(승인여부) 수정
    public CancelledLectureEntity update(ApplyDto applyDto) {
        CancelledLectureEntity entity = cancelledLectureRepository.findById(applyDto.getCancelledLectureIdx()).orElseThrow(() -> new RuntimeException("휴강에 관련된 게시글을 찾을 수 없습니다."));
        entity.setCancelledApply(applyDto.getCancelledApply());
        return cancelledLectureRepository.save(entity);
    }



}
