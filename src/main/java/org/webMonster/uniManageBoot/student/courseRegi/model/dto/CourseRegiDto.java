package org.webMonster.uniManageBoot.student.courseRegi.model.dto;

import lombok.*;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CourseRegiDto {
    private long courseRegiId;   //수강신청 번호

    private long memberId;   //멤버 번호

    private long lectureId;   //강의 아이디

    private long courseRegiTerm;   //신청학기


    private String lectureTitle; // 강의명

    private String timecode1; // 강의시간코드1
    private String timecode2; // 강의시간코드2
    private String timecode3;  // 강의시간코드3
    private int numberOfStudent;   //정원
    private int credit;   //학점
    private String roomcode1;   //강의실코드1
    private String roomcode2;   //강의실코드2
    private String roomcode3;   //강의실코드3

}
