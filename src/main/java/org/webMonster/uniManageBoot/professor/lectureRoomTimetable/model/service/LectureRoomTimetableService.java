package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.common.SearchRoom;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableRepository;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableRepositoryCustom;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.model.dto.LectureRoomTimetableDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LectureRoomTimetableService {
    private final LectureRoomTimetableRepository lectureRoomTimetableRepository;
    private final LectureRoomTimetableRepositoryCustom lectureRoomTimetableRepositoryCustom;

    //강의실 리스트 조회
    public Header<List<LectureRoomTimetableDto>> getLectureRoomList(Pageable pageable, SearchRoom searchRoom) {
        List<LectureRoomTimetableDto> dtos = new ArrayList<>();

        Page<LectureRoomTimetableEntity> lectureRoomTimetableEntities = lectureRoomTimetableRepositoryCustom.findAllBySearchConditionAndStatus(pageable, searchRoom);
        for (LectureRoomTimetableEntity entity : lectureRoomTimetableEntities) {
            LectureRoomTimetableDto dto = LectureRoomTimetableDto.builder()
                    .lectureRoomTimetableIdx(entity.getLectureRoomTimetableIdx())
                    .timecode(entity.getTimecode())
                    .lectureRoomCode(entity.getLectureRoomCode())
                    .operation(entity.getOperation())
                    .buildingName(entity.getLectureClass().getBuildingName())
                    .lectureRoomNum(entity.getLectureClass().getLectureRoomNum())
                    .classCapacity(entity.getLectureClass().getClassCapacity())
                    .dayTime(entity.getLectureClassTime().getDayTime())
                    .startTime(entity.getLectureClassTime().getStartTime())
                    .build();
            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) lectureRoomTimetableEntities.getTotalElements(),
                pageable.getPageNumber() + 1,
                pageable.getPageSize(),
                10
        );

        return Header.OK(dtos, pagination);
    }
}
