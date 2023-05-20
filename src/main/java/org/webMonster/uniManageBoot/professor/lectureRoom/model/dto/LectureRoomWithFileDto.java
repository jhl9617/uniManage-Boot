package org.webMonster.uniManageBoot.professor.lectureRoom.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LectureRoomWithFileDto {
    private LectureRoomDto lectureRoom;
    private LectureRoomFileDto lectureRoomFile;

}
