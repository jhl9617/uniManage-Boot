package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.model.dto.LectureRoomTimetableDto;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.model.service.LectureRoomTimetableService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class LectureRoomTimetableController {
    private final LectureRoomTimetableService lectureRoomTimetableService;

    @PostMapping("prof/create/room")
    public Header<List<LectureRoomTimetableDto>> lectureRoomList(@PageableDefault(sort = {"lecture_room_timetable_idx"}, direction = Sort.Direction.DESC) Pageable pageable, SearchCondition searchCondition) {
        return lectureRoomTimetableService.getLectureRoomList(pageable, searchCondition);
    }
}
