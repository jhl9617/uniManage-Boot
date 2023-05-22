package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class LectureRoomTimetableDto {
    private long lectureRoomTimetableIdx;
    private String timecode;
    private String lectureRoomCode;
    private char operation;

    private String buildingName;    //건물이름
    private String lectureRoomNum;  //강의실 호수
    private String dayTime;         //요일
    private String startTime;       //시작시간
    private int classCapacity;      //수용인원
}
