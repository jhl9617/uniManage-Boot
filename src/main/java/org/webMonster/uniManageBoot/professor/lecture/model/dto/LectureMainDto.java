package org.webMonster.uniManageBoot.professor.lecture.model.dto;

import lombok.*;
import org.webMonster.uniManageBoot.professor.homework.model.dto.HomeworkDto;
import org.webMonster.uniManageBoot.professor.lectureNotice.model.dto.LectureNoticeDto;
import org.webMonster.uniManageBoot.professor.lectureRoom.model.dto.LectureRoomDto;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class LectureMainDto {
    private LectureDto lectureDto;
    private List<FreeboardDto> freeboardDto;
    private List<HomeworkDto> homeworkDto;
    private List<LectureRoomDto> lectureRoomDto;
    private List<LectureNoticeDto> lectureNoticeDto;
}
