package org.webMonster.uniManageBoot.professor.cancelledLecture.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureEntity;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureRepository;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureRepositoryCustom;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.CancelledLectureDto;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.ApplyDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CancelledLectureService {
    private final CancelledLectureRepository cancelledLectureRepository;
    private final CancelledLectureRepositoryCustom cancelledLectureRepositoryCustom;


    //교수전체 휴강신청 리스트 조회(교직원용)
    public Header<List<CancelledLectureDto>> getAdminCancelledLectureList(Pageable pageable, SearchCondition searchCondition) {
        List<CancelledLectureDto> dtos = new ArrayList<>();

        Page<CancelledLectureEntity> cancelledLectureEntities = cancelledLectureRepositoryCustom.findAllBySearchConditionAndStatus(pageable, searchCondition);
        for(CancelledLectureEntity entity : cancelledLectureEntities){
            CancelledLectureDto dto = CancelledLectureDto.builder()
                    .cancelledLectureIdx(entity.getCancelledLectureIdx())
                    .memberId(entity.getMember().getMemberId())
                    .lectureId(entity.getLecture().getLectureId())
                    .lectureRoomCode(entity.getLectureClass().getLectureRoomCode())
                    .attendanceDay(entity.getAttendanceDay())
                    .supplyDate(entity.getSupplyDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                    .reason(entity.getReason())
                    .cancelledFile(entity.getCancelledFile())
                    .cancelledFileRename(entity.getCancelledFileRename())
                    .cancelledApply(entity.getCancelledApply())
                    .build();
            dtos.add(dto);
        }
        Pagination pagination = new Pagination(
                (int) cancelledLectureEntities.getTotalElements(),
                pageable.getPageNumber() + 1,
                pageable.getPageSize(),
                10
        );
        return Header.OK(dtos, pagination);
    }


    //교수 휴강신청 리스트 조회(교수용)
    public Header<List<CancelledLectureDto>> getProfCancelledLectureList(Pageable pageable, SearchCondition searchCondition, Long memberId) {
        List<CancelledLectureDto> dtos = new ArrayList<>();
        Page<CancelledLectureEntity> cancelledLectureEntities = cancelledLectureRepositoryCustom.findAllBySearchConditionAndStatusByMemberId(pageable, searchCondition, memberId);
        System.out.println("왜 안 나올까요...ㅠ");
        
        for (CancelledLectureEntity entity : cancelledLectureEntities) {
            if (memberId.equals(entity.getMember().getMemberId())) {
                CancelledLectureDto dto = CancelledLectureDto.builder()
                        .cancelledLectureIdx(entity.getCancelledLectureIdx())
                        .memberId(entity.getMember().getMemberId())
                        .lectureId(entity.getLecture().getLectureId())
                        .lectureRoomCode(entity.getLectureClass().getLectureRoomCode())
                        .attendanceDay(entity.getAttendanceDay())
                        .supplyDate(entity.getSupplyDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .reason(entity.getReason())
                        .cancelledFile(entity.getCancelledFile())
                        .cancelledFileRename(entity.getCancelledFileRename())
                        .cancelledApply(entity.getCancelledApply())
                        .build();
                dtos.add(dto);
                System.out.println("서비스1" + cancelledLectureEntities);
            }
            Pagination pagination = new Pagination(
                    (int) cancelledLectureEntities.getTotalElements(),
                    pageable.getPageNumber() + 1,
                    pageable.getPageSize(),
                    10
            );
            System.out.println("서비스2" + cancelledLectureEntities);
            return Header.OK(dtos, pagination);
        }
        return null;
    }


    //휴강신청 상세보기
    public CancelledLectureDto getCancelledLecture(Long id) {
        CancelledLectureEntity entity = cancelledLectureRepository.findById(id).orElseThrow(() -> new RuntimeException("휴강내역 신청글을 찾을 수 없습니다."));
        return CancelledLectureDto.builder()
                .lectureId(entity.getLecture().getLectureId())
                .memberId(entity.getMember().getMemberId())
                .lectureRoomCode(entity.getLectureClass().getLectureRoomCode())
                .attendanceDay(entity.getAttendanceDay())
                .supplyDate(entity.getSupplyDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .reason(entity.getReason())
                .cancelledFile(entity.getCancelledFile())
                .cancelledFileRename(entity.getCancelledFileRename())
                .build();
    }


    //휴강게시글 생성(교수용)
    public CancelledLectureEntity create(CancelledLectureDto cancelledLectureDto) {
        CancelledLectureEntity dto = CancelledLectureEntity.builder()
                .lectureId(cancelledLectureDto.getLectureId())
                .memberId(cancelledLectureDto.getMemberId())
                .lectureRoomCode(cancelledLectureDto.getLectureRoomCode())
                .attendanceDay(cancelledLectureDto.getAttendanceDay())
                .supplyDate(LocalDateTime.parse(cancelledLectureDto.getSupplyDate()))
                .reason(cancelledLectureDto.getReason())
                .cancelledFile(cancelledLectureDto.getCancelledFile())
                .cancelledFileRename(cancelledLectureDto.getCancelledFileRename())
                .cancelledApply(cancelledLectureDto.getCancelledApply())
                .build();
        return cancelledLectureRepository.save(dto);
    }


    //휴강게시글 승인여부 수정(교직원용)
    public CancelledLectureEntity update(ApplyDto applyDto) {
        CancelledLectureEntity entity = cancelledLectureRepository.findById(applyDto.getMemberId()).orElseThrow(() -> new RuntimeException("휴강신청 내역을 찾을 수 없습니다."));
        entity.setCancelledApply(applyDto.getCancelledApply());
        return cancelledLectureRepository.save(entity);
    }
}
