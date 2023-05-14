package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_ROOM_TIMETABLE")
@Entity
public class LectureRoomTimetableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_ROOM_TIMETABLE_IDX")
    private long lectureRoomTimetableIdx;   //강의실시간표 번호
    @Column(name = "TIMECODE")
    private String timecode;   //시간코드
    @Column(name = "LECTURE_ROOM_CODE")
    private String lectureRoomCode;   //강의실코드

}
