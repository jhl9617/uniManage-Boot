package org.webMonster.uniManageBoot.professor.lectureNotice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_NOTICE")
@Entity
public class LectureNoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_NOTICE_ID")
    private long lecture_notice_id;   //강의공지 글번호
    @Column(name = "LECTURE_ID")
    private long lecture_id;   //강의번호
    @Column(name = "LECTURE_NOTICE_TITLE")
    private String lecture_notice_title;   //강의공지 제목
    @Column(name = "LECTURE_NOTICE_CONTENT")
    private String lecture_notice_content;   //강의공지 내용
    @Column(name = "CREATED_DATE")
    private LocalDateTime created_date;   //강의공지 작성일
    @Column(name = "READCOUNT")
    private int readcount;   //조회수

}
