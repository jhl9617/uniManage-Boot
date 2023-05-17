package org.webMonster.uniManageBoot.professor.lecture.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class LectureDto {
    private long lectureId;
    private long memberId;
    private char classification;
    private long semester;
    private long departmentId;
    private String lectureTitle;
    private int numberOfStudent;
    private int credit;
    private String roomcode1;
    private String roomcode2;
    private String roomcode3;
    private String timecode1;
    private String timecode2;
    private String timecode3;
    private String syllabusTitle;
    private String syllabusRename;
    private char lectureApplyStatus;

    //교수 이름
    private String name;

    //학과 이름
    private String departmentName;

    //강의실관련
    private String buildingCode;
    private String lectureRoomNum;
    private int classCapacity;


}
