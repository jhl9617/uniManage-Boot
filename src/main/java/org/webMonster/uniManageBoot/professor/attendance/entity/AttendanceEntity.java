package org.webMonster.uniManageBoot.professor.attendance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ATTENDANCE")
@Entity
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATTENDANCE_IDX")
    private long attendance_idx;   //순번
    @Column(name = "ATTENDANCE_ID")
    private long attendance_id;   //출석 아이디
    @Column(name = "MEMBER_ID")
    private long member_id;  //학생 번호
    @Column(name = "LECTURE_ID")
    private long lecture_id;   //강의 번호
    @Column(name = "ATTENDED")
    private char attended;   //출석여부
}
