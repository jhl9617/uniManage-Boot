package org.webMonster.uniManageBoot.professor.lectureInfo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_INFO")
@Entity
public class LectureInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATTENDANCE_ID")
    private long attendance_id;   //출석 아이디
    @Column(name = "LECTURE_ID")
    private long lecture_id;   //강의 번호
    @Column(name = "TIMECODE")
    private String timecode;   //시간코드
    @Column(name = "LECTURE_ROOM_CODE")
    private String lecture_room_code;   //강의실 코드
    @Column(name = "MAX_CHECKIN")
    private int max_checkin;   //최대회차
    @Column(name = "NOW_CHECKIN")
    private int now_checkin;   //현재회차
    @Column(name = "LECTURE_DATE")
    private Date lecture_date;   //수업날짜
}
