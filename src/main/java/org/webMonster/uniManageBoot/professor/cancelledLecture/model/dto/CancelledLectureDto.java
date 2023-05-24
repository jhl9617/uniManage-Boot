package org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CancelledLectureDto {
    private long cancelledLectureIdx;   //휴강게시글 시퀀스
    private long lectureId;             //강의번호
    private long memberId;              //아이디(작성자)
    private String lectureRoomCode;     //바뀐 강의실 코드
    private int attendanceDay;          //수업회차
    private Date supplyDate;            //보강일시
    private String reason;              //보강사유
    private String cancelledFile;       //제출된 파일명
    private String cancelledFileRename;     //변경된 제출서류 파일명
    private char cancelledApply;        //휴강승인여부
}
