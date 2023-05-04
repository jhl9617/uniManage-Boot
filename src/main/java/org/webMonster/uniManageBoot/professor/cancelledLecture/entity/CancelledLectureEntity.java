package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

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
@Table(name = "CANCELLED_LECTURE")
@Entity
public class CancelledLectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_ID")
    private long lecture_id;   //강의번호
    @Column(name = "MEMBER_ID")
    private long member_id;   //아이디
    @Column(name = "LECTURE_ROOM_CODE")
    private String lecture_room_code;   //바뀐 강의실 코드
    @Column(name = "ATTENDANCE_DAY")
    private int attendance_day;   //수업회차
    @Column(name = "SUPPLY_DATE")
    private Date supply_date;   //보강일시
    @Column(name = "REASON")
    private String reason;   //사유
    @Column(name = "CANCELLED_FILE")
    private String cancelled_file;   //제출서류 파일명
    @Column(name = "CANCELLED_RENAME")
    private String cancelled_rename;   //변경된 제출서류 파일명
    @Column(name = "CANCELLED_APPLY")
    private char cancelled_apply;   //휴강승인여부

}
