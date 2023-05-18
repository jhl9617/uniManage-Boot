package org.webMonster.uniManageBoot.professor.lectureNotice.model.dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LectureNoticeDto {

    private long lectureNoticeId;   //강의공지 글번호

    private long lectureId;   //강의번호

    private String lectureNoticeTitle;   //강의공지 제목

    private String lectureNoticeContent;   //강의공지 내용

    private String createdDate;   //강의공지 작성일

    private int readcount;   //조회수
}
