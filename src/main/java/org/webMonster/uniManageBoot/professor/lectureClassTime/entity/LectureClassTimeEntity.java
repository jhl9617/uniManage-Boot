package org.webMonster.uniManageBoot.professor.lectureClassTime.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_CLASS_TIME")
@Entity
public class LectureClassTimeEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecture_class_time_idx_seq_gen")
    @SequenceGenerator(
            name = "lecture_class_time_idx_seq_gen",
            sequenceName = "LECTURE_CLASS_TIME_IDX_SEQ",
            allocationSize = 1
    )
    @Column(name = "LECTURE_CLASS_TIME_IDX")
    private long lectureClassTimeIdx;   //강의실시간표 번호
    @Column(name = "TIMECODE")
    private String timecode;   //시간코드
    @Column(name = "START_TIME")
    private String startTime;   //시작시간
    @Column(name = "DAY_TIME")
    private String dayTime;   //요일

    // 다른 엔티티와의 관계 설정
    @Builder.Default
    @OneToMany(mappedBy = "lectureClassTime")
    private List<LectureRoomTimetableEntity> lectureRoomTimetables = new ArrayList<>();


}
