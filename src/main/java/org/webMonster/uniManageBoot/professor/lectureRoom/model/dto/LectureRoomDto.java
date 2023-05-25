package org.webMonster.uniManageBoot.professor.lectureRoom.model.dto;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LectureRoomDto {

    private long lectureRoomId;   //강의자료실 글번호

    private long lectureId;   //강의번호

    private long memberId;   //아이디

    private String lectureRoomTitle;   //강의자료 제목

    private String lectureRoomContent;   //강의자료 내용

    private String createdDate;   //강의자료 작성일

    private int readcount;   //조회수

    private String name; // 작성자
}
