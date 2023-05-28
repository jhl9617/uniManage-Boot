package org.webMonster.uniManageBoot.professor.cancelledLecture.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CANCELLED_LECTURE")
@Entity
@Getter
@Setter
public class CancelledLectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCELLED_LECTURE_IDX_SEQ")
    @SequenceGenerator(
            name = "CANCELLED_LECTURE_IDX_SEQ",
            sequenceName = "CANCELLED_LECTURE_IDX_SEQ",
            allocationSize = 1
    )
    @Column(name = "CANCELLED_LECTURE_IDX")
    private Long cancelledLectureIdx;   //휴강게시물 시퀀스
    @Column(name = "LECTURE_ID", insertable = false, updatable = false)
    private Long lectureId;             //강의번호
    @Column(name = "MEMBER_ID", insertable = false, updatable = false)
    private Long memberId;              //아이디(작성자)
    @Column(name = "LECTURE_ROOM_CODE", insertable = false, updatable = false)
    private String lectureRoomCode; //바뀐 강의실 코드
    @Column(name = "ATTENDANCE_DAY")
    private int attendanceDay;              //수업회차
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "SUPPLY_DATE")
    private LocalDateTime supplyDate;                //보강일시
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
    @JoinColumn(name = "LECTURE_ID")
    private LectureEntity lecture;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ROOM_CODE")
    private LectureClassEntity lectureClass;
}
