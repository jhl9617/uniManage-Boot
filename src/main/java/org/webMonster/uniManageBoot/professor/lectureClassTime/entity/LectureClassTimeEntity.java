package org.webMonster.uniManageBoot.professor.lectureClassTime.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_CLASS_TIME")
@Entity
public class LectureClassTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_CLASS_TIME_IDX")
    private long lectureClassTimeIdx;   //강의실시간표 번호
    @Column(name = "TIMECODE")
    private String timecode;   //시간코드
    @Column(name = "START_TIME")
    private String startTime;   //시작시간
    @Column(name = "DAY_TIME")
    private String dayTime;   //요일
}
