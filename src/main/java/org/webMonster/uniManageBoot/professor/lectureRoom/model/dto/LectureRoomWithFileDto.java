package org.webMonster.uniManageBoot.professor.lectureRoom.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LectureRoomWithFileDto {
    private LectureRoomDto lectureRoom;
    private LectureRoomFileDto lectureRoomFile;

}
