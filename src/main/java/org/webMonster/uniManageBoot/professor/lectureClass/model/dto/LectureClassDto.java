package org.webMonster.uniManageBoot.professor.lectureClass.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class LectureClassDto {

    private long lectureClassIdx;
    private String lectureRoomCode;
    private String buildingCode;
    private String buildingName;
    private int numberFloor;
    private String lectureRoomNum;
    private int classCapacity;

}
