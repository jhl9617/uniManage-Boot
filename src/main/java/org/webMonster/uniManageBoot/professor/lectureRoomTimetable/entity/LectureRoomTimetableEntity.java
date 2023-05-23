package org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity;

import com.querydsl.core.support.ExtendedSubQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;
import org.webMonster.uniManageBoot.professor.lectureClassTime.entity.LectureClassTimeEntity;

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

    @Column(name = "OPERATION")
    private char operation; //사용여부

    // 다른 엔티티와의 관계 설정
    @ManyToOne
    @JoinColumn(name = "LECTURE_ROOM_CODE", insertable = false, updatable = false)
    private LectureClassEntity lectureClass;

    // 다른 엔티티와의 관계 설정
    @ManyToOne
    @JoinColumn(name = "TIMECODE", insertable = false, updatable = false)
    private LectureClassTimeEntity lectureClassTime;

}
