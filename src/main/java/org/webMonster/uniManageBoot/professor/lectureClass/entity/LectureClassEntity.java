package org.webMonster.uniManageBoot.professor.lectureClass.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_CLASS")
@Entity
public class LectureClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_ROOM_CODE")
    private String lecture_room_code;   //강의실 코드
    @Column(name = "BUILDING_CODE")
    private String building_code;   //건물코드
    @Column(name = "BUILDING_NAME")
    private String building_name;   //건물명
    @Column(name = "NUMBER_FLOOR")
    private int number_floor;   //층수
    @Column(name = "LECTURE_ROOM_NUM")
    private String lecture_room_num;   //강의실 호수
    @Column(name = "CLASS_CAPACITY")
    private int class_capacity;   //강의실 수용인원
}
