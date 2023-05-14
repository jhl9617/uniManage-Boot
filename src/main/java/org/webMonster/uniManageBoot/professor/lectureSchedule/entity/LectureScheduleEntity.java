package org.webMonster.uniManageBoot.professor.lectureSchedule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_SCHEDULE")
@Entity
public class LectureScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private long memberId;   //아이디
    @Column(name = "TIMECODE")
    private String timecode;  //시간코드
    @Column(name = "LECTURE_ID")
    private long lectureId;  //강의번호
}
