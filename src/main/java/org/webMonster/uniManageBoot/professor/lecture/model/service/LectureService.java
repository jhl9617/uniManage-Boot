package org.webMonster.uniManageBoot.professor.lecture.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeEntity;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureRepository;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureRepositoryCustom;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.LectureDto;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.SearchValues;

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

    //교직원  개설 강의 관리 글 상세보기 조회
    public LectureDto getLecture(Long id) {
        LectureEntity entity = lectureRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
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
                .timecode2(entity.getTimecode2())
                .timecode3(entity.getTimecode3())
                .syllabusTitle(entity.getSyllabusTitle())
                .syllabusRename(entity.getSyllabusRename())
                .lectureApplyStatus(entity.getLectureApplyStatus())
                .name(entity.getMember().getName())
                .departmentName(entity.getDepartment().getDepartmentName())
                .build();
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

    public Header<List<LectureDto>> getProfLectureList(Pageable pageable, SearchCondition searchCondition, Long memberId) {
        List<LectureDto> dtos = new ArrayList<>();

        Page<LectureEntity> lectureEntities = lectureRepositoryCustom.findBySearchConditionAndStatus(pageable, searchCondition, memberId);
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
                    .timecode2(entity.getTimecode2())
                    .timecode3(entity.getTimecode3())
                    .syllabusTitle(entity.getSyllabusTitle())
                    .syllabusRename(entity.getSyllabusRename())
                    .lectureApplyStatus(entity.getLectureApplyStatus())
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
    public Header<List<LectureDto>> getStudentLectureList(Pageable pageable, SearchValues searchValues) {
        List<LectureDto> dtos = new ArrayList<>();

        Page<LectureEntity> lectureEntities = lectureRepositoryCustom.findBySearchValues(pageable, searchValues);
        for (LectureEntity entity : lectureEntities) {
            LectureDto dto = LectureDto.builder()
                    .name(entity.getMember().getName())
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
                    .timecode2(entity.getTimecode2())
                    .timecode3(entity.getTimecode3())
                    .syllabusTitle(entity.getSyllabusTitle())
                    .syllabusRename(entity.getSyllabusRename())
                    .lectureApplyStatus(entity.getLectureApplyStatus())
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

    //교수 강의 신청
    public LectureEntity create(LectureDto lectureDto) {
        LectureEntity entity = LectureEntity.builder()
                .lectureId(lectureDto.getLectureId())
                .memberId(lectureDto.getMemberId())
                .classification(lectureDto.getClassification())
                .semester(lectureDto.getSemester())
                .departmentId(lectureDto.getDepartmentId())
                .lectureTitle(lectureDto.getLectureTitle())
                .numberOfStudent(lectureDto.getNumberOfStudent())
                .credit(lectureDto.getCredit())
                .roomcode1(lectureDto.getRoomcode1())
                .roomcode2(lectureDto.getRoomcode2())
                .roomcode3(lectureDto.getRoomcode3())
                .timecode1(lectureDto.getTimecode1())
                .timecode2(lectureDto.getTimecode2())
                .timecode3(lectureDto.getTimecode3())
                .syllabusTitle(lectureDto.getSyllabusTitle())
                .syllabusRename(lectureDto.getSyllabusRename())
                .lectureApplyStatus(lectureDto.getLectureApplyStatus())
                .build();
        return lectureRepository.save(entity);
    }

    //교수 신청 강의 수정
    public LectureEntity update(LectureDto lectureDto) {
        LectureEntity entity = lectureRepository.findById(lectureDto.getLectureId()).orElseThrow(() -> new RuntimeException("강의를 찾을 수 없습니다."));
        entity.setLectureTitle(lectureDto.getLectureTitle());
        entity.setClassification(lectureDto.getClassification());
        entity.setSemester(lectureDto.getSemester());
        entity.setCredit(lectureDto.getCredit());
        entity.setRoomcode1(lectureDto.getRoomcode1());
        entity.setTimecode1(lectureDto.getTimecode1());
        entity.setRoomcode2(lectureDto.getRoomcode2());
        entity.setTimecode2(lectureDto.getTimecode2());
        entity.setRoomcode3(lectureDto.getRoomcode3());
        entity.setTimecode3(lectureDto.getTimecode3());
        entity.setSyllabusTitle(lectureDto.getSyllabusTitle());
        entity.setSyllabusRename(lectureDto.getSyllabusRename());
        entity.setNumberOfStudent(lectureDto.getNumberOfStudent());
        return lectureRepository.save(entity);
    }

    //교수 신청 강의 삭제
    public void delete(Long id) {
        LectureEntity entity = lectureRepository.findById(id).orElseThrow(() -> new RuntimeException("강의를 찾을 수 없습니다."));
        lectureRepository.delete(entity);
    }

    //교수 신청 강의 상세보기
    public LectureDto getProfLecture(Long id) {
        LectureEntity entity = lectureRepository.findById(id).orElseThrow(() -> new RuntimeException("강의를 찾을 수 없습니다."));
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
                .timecode2(entity.getTimecode2())
                .timecode3(entity.getTimecode3())
                .syllabusTitle(entity.getSyllabusTitle())
                .syllabusRename(entity.getSyllabusRename())
                .lectureApplyStatus(entity.getLectureApplyStatus())
                .name(entity.getMember().getName())
                .departmentName(entity.getDepartment().getDepartmentName())
                .build();
    }

    //교수 승인 강의 리스트 확인
    public Header<List<LectureDto>> profSuccessLectureList(Pageable pageable, SearchCondition searchCondition, Long memberId) {
        List<LectureDto> dtos = new ArrayList<>();

        Page<LectureEntity> lectureEntities = lectureRepositoryCustom.findBySearchConditionsAndStatus(pageable, searchCondition, memberId);
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
                    .timecode2(entity.getTimecode2())
                    .timecode3(entity.getTimecode3())
                    .syllabusTitle(entity.getSyllabusTitle())
                    .syllabusRename(entity.getSyllabusRename())
                    .lectureApplyStatus(entity.getLectureApplyStatus())
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

    //학생 수강신청할 수 있는 강의 목록 출력용
    public Header<List<LectureDto>> getLectureListForSugang(Pageable pageable, SearchCondition searchCondition) {
        List<LectureDto> dtos = new ArrayList<>();

        Page<LectureEntity> lectureEntities = lectureRepositoryCustom.findAllBySearchRoomAndStatus(pageable, searchCondition);
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
}
