package org.webMonster.uniManageBoot.professor.lectureClass.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_CLASS")
@Entity
public class LectureClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecture_class_idx_seq_gen")
    @SequenceGenerator(name = "lecture_class_idx_seq_gen", sequenceName = "LECTURE_CLASS_IDX_SEQ", allocationSize = 1)
    @Column(name = "LECTURE_CLASS_IDX")
    private long lectureClassIdx;   //강의실 번호
    @Column(name = "LECTURE_ROOM_CODE")
    private String lectureRoomCode;   //강의실 코드
    @Column(name = "BUILDING_CODE")
    private String buildingCode;   //건물코드
    @Column(name = "BUILDING_NAME")
    private String buildingName;   //건물명
    @Column(name = "NUMBER_FLOOR")
    private int numberFloor;   //층수
    @Column(name = "LECTURE_ROOM_NUM")
    private String lectureRoomNum;   //강의실 호수
    @Column(name = "CLASS_CAPACITY")
    private int classCapacity;   //강의실 수용인원

    //    @Builder.Default
//    @OneToMany(mappedBy = "lectureClass")
//    private List<LectureEntity> lectureEntities = new ArrayList<>();
// 다른 엔티티와의 관계 설정
    @OneToMany(mappedBy = "lectureClass")
    private List<LectureRoomTimetableEntity> lectureRoomTimetables;
}
