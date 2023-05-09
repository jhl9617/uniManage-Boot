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
    private long lectureId;   //강의번호
    @Column(name = "MEMBER_ID")
    private long memberId;   //아이디
    @Column(name = "LECTURE_ROOM_CODE")
    private String lectureRoomCode;   //바뀐 강의실 코드
    @Column(name = "ATTENDANCE_DAY")
    private int attendanceDay;   //수업회차
    @Column(name = "SUPPLY_DATE")
    private Date supplyDate;   //보강일시
    @Column(name = "REASON")
    private String reason;   //사유
    @Column(name = "CANCELLED_FILE")
    private String cancelledFile;   //제출서류 파일명
    @Column(name = "CANCELLED_RENAME")
    private String cancelledRename;   //변경된 제출서류 파일명
    @Column(name = "CANCELLED_APPLY")
    private char cancelledApply;   //휴강승인여부

}
