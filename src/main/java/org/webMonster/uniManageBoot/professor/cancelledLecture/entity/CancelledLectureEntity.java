package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;

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
    @Column(name = "CANCELLED_LECTURE_IDX_SEQ")
    private long cancelledLectureIdx;   //휴강게시물 시퀀스
    @Column(name = "LECTURE_ID")
    private long lectureId;             //강의번호
    @Column(name = "MEMBER_ID")
    private long memberId;              //아이디(작성자)
    @Column(name = "LECTURE_ROOM_CODE")
    private String lectureRoomCode; //바뀐 강의실 코드
    @Column(name = "ATTENDANCE_DAY")
    private int attendanceDay;              //수업회차
    @Column(name = "SUPPLY_DATE")
    private Date supplyDate;                //보강일시
    @Column(name = "REASON")
    private String reason;                  //휴강사유
    @Column(name = "CANCELLED_FILE")
    private String cancelledFile;           //제출서류 파일명
    @Column(name = "CANCELLED_FILE_RENAME")
    private String cancelledFileRename;         //변경된 제출서류 파일명

    @Builder.Default
    @Column(name = "CANCELLED_APPLY")
    private char cancelledApply = 1;        //휴강승인여부

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID", insertable = false, updatable = false)
    private LectureEntity lecture;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", insertable = false, updatable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ROOM_CODE", insertable = false, updatable = false)
    private LectureClassEntity lectureClass;
}
