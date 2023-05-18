package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.model.service;

import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableRepository;

import java.util.List;

@Service
public class LectureRoomTimetableService {
    private final LectureRoomTimetableRepository lectureRoomTimetableRepository;

    public LectureRoomTimetableService(LectureRoomTimetableRepository lectureRoomTimetableRepository) {
        this.lectureRoomTimetableRepository = lectureRoomTimetableRepository;
    }

    public List<LectureRoomTimetableEntity> getLectureRoomTimetables() {
        return lectureRoomTimetableRepository.findAll();
    }
}
