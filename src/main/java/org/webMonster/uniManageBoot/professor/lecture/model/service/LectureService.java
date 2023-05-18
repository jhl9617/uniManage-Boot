package org.webMonster.uniManageBoot.professor.lecture.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureRepository;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureRepositoryCustom;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.LectureDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    private final LectureRepositoryCustom lectureRepositoryCustom;

    // 교직원 개설 강의 관리 리스트 조회
    public Header<List<LectureDto>> getLectureList(Pageable pageable, SearchCondition searchCondition) {
        List<LectureDto> dtos = new ArrayList<>();

        Page<LectureEntity> lectureEntities = lectureRepositoryCustom.findAllBySearchConditionAndStatus(pageable, searchCondition);
        for (LectureEntity entity : lectureEntities) {
            LectureDto dto = LectureDto.builder()
                    .lectureId(entity.getLectureId())
                    .memberId(entity.getMemberId())
                    .classification(entity.getClassification())
                    .semester(entity.getSemester())
                    .departmentId(entity.getDepartmentId())
                    .lectureTitle(entity.getLectureTitle())
                    .numberOfStudent(entity.getNumberOfStudent())
                    .credit(entity.getCredit())
                    .roomcode1(entity.getRoomcode1())
                    .roomcode2(entity.getRoomcode2())
                    .roomcode3(entity.getRoomcode3())
                    .timecode1(entity.getTimecode1())
                    .timecode2(entity.getTimecode1())
                    .timecode2(entity.getTimecode2())
                    .timecode3(entity.getTimecode3())
                    .syllabusTitle(entity.getSyllabusTitle())
                    .syllabusRename(entity.getSyllabusRename())
                    .lectureApplyStatus(entity.getLectureApplyStatus())
                    .name(entity.getMember().getName())
                    .departmentName(entity.getDepartment().getDepartmentName())
                    .build();
            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) lectureEntities.getTotalElements(),
                pageable.getPageNumber() + 1,
                pageable.getPageSize(),
                10
        );

        return Header.OK(dtos, pagination);
    }

    // 교직원 강의개설요청관리 리스트 조회
    public Header<List<LectureDto>> getAppliedLectureList(Pageable pageable, SearchCondition searchCondition) {
        List<LectureDto> dtos = new ArrayList<>();

        Page<LectureEntity> appliedLectureEntities = lectureRepositoryCustom.findAllBySearchConditionsAndStatus(pageable, searchCondition);
        for (LectureEntity entity : appliedLectureEntities) {
            LectureDto dto = LectureDto.builder()
                    .lectureId(entity.getLectureId())
                    .memberId(entity.getMemberId())
                    .classification(entity.getClassification())
                    .semester(entity.getSemester())
                    .departmentId(entity.getDepartmentId())
                    .lectureTitle(entity.getLectureTitle())
                    .numberOfStudent(entity.getNumberOfStudent())
                    .credit(entity.getCredit())
                    .roomcode1(entity.getRoomcode1())
                    .roomcode2(entity.getRoomcode2())
                    .roomcode3(entity.getRoomcode3())
                    .timecode1(entity.getTimecode1())
                    .timecode2(entity.getTimecode1())
                    .timecode2(entity.getTimecode2())
                    .timecode3(entity.getTimecode3())
                    .syllabusTitle(entity.getSyllabusTitle())
                    .syllabusRename(entity.getSyllabusRename())
                    .lectureApplyStatus(entity.getLectureApplyStatus())
                    .name(entity.getMember().getName())
                    .departmentName(entity.getDepartment().getDepartmentName())
                    .build();
            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) appliedLectureEntities.getTotalElements(),
                pageable.getPageNumber() + 1,
                pageable.getPageSize(),
                10
        );

        return Header.OK(dtos, pagination);
    }

    //교직원 강의 관리 글 상세보기 조회
    public LectureDto getLecture(Long id) {
        LectureEntity entity = lectureRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return LectureDto.builder()
                .lectureId(entity.getLectureId())
                .memberId(entity.getMemberId())
                .classification(entity.getClassification())
                .semester(entity.getSemester())
                .departmentId(entity.getDepartmentId())
                .lectureTitle(entity.getLectureTitle())
                .numberOfStudent(entity.getNumberOfStudent())
                .credit(entity.getCredit())
                .roomcode1(entity.getRoomcode1())
                .roomcode2(entity.getRoomcode2())
                .roomcode3(entity.getRoomcode3())
                .timecode1(entity.getTimecode1())
                .timecode2(entity.getTimecode1())
                .timecode2(entity.getTimecode2())
                .timecode3(entity.getTimecode3())
                .syllabusTitle(entity.getSyllabusTitle())
                .syllabusRename(entity.getSyllabusRename())
                .lectureApplyStatus(entity.getLectureApplyStatus())
                .name(entity.getMember().getName())
                .departmentName(entity.getDepartment().getDepartmentName())
                .build();
    }
}
