package org.webMonster.uniManageBoot.professor.lectureClass.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassRepository;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassRepositoryCustom;
import org.webMonster.uniManageBoot.professor.lectureClass.model.dto.LectureClassDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LectureClassService {
    private final LectureClassRepository lectureClassRepository;
    private final LectureClassRepositoryCustom lectureClassRepositoryCustom;

    //교직원 강의실관리 리스트 조회
    public Header<List<LectureClassDto>> getLectureClassList(Pageable pageable, SearchCondition searchCondition) {
        List<LectureClassDto> dtos = new ArrayList<>();

        Page<LectureClassEntity> LectureClassEntities = lectureClassRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (LectureClassEntity entity : LectureClassEntities) {
            LectureClassDto dto = LectureClassDto.builder()
                    .lectureClassIdx(entity.getLectureClassIdx())
                    .lectureRoomCode(entity.getLectureRoomCode())
                    .buildingCode(entity.getBuildingCode())
                    .buildingName(entity.getBuildingName())
                    .numberFloor(entity.getNumberFloor())
                    .lectureRoomNum(entity.getLectureRoomNum())
                    .classCapacity(entity.getClassCapacity())
                    .build();
            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) LectureClassEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }

    //교직원 강의실관리 글 상세보기 조회
    public LectureClassDto getLectureClass(Long id) {
        LectureClassEntity entity = lectureClassRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
        return LectureClassDto.builder()
                .lectureClassIdx(entity.getLectureClassIdx())
                .lectureRoomCode(entity.getLectureRoomCode())
                .buildingCode(entity.getBuildingCode())
                .buildingName(entity.getBuildingName())
                .numberFloor(entity.getNumberFloor())
                .lectureRoomNum(entity.getLectureRoomNum())
                .classCapacity(entity.getClassCapacity())
                .build();
    }

    //교직원 강의실관리 추가
    public LectureClassEntity create(LectureClassDto lectureClassDto) {
        LectureClassEntity entity = LectureClassEntity.builder()
                .lectureClassIdx(lectureClassDto.getLectureClassIdx())
                .lectureRoomCode(lectureClassDto.getLectureRoomCode())
                .buildingCode(lectureClassDto.getBuildingCode())
                .buildingName(lectureClassDto.getBuildingName())
                .numberFloor(lectureClassDto.getNumberFloor())
                .lectureRoomNum(lectureClassDto.getLectureRoomNum())
                .classCapacity(lectureClassDto.getClassCapacity())
                .build();
        return lectureClassRepository.save(entity);
    }

    //교직원 강의실관리 수정
    public LectureClassEntity update(LectureClassDto lectureClassDto) {
        LectureClassEntity entity = lectureClassRepository.findById(lectureClassDto.getLectureClassIdx()).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
        entity.setLectureClassIdx(lectureClassDto.getLectureClassIdx());
        entity.setLectureRoomCode(lectureClassDto.getLectureRoomCode());
        entity.setBuildingCode(lectureClassDto.getBuildingCode());
        entity.setBuildingName(lectureClassDto.getBuildingName());
        entity.setNumberFloor(lectureClassDto.getNumberFloor());
        entity.setLectureRoomNum(lectureClassDto.getLectureRoomNum());
        entity.setClassCapacity(lectureClassDto.getClassCapacity());
        return lectureClassRepository.save(entity);
    }

    //교직원 강의실관리 삭제
    public void delete(Long id) {
        LectureClassEntity entity = lectureClassRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 글을 찾을 수 없습니다."));
        lectureClassRepository.delete(entity);
    }
}
