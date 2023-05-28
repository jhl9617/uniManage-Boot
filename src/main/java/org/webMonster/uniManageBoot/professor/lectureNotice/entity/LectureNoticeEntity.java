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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecture_notice_id_seq_gen")
    @SequenceGenerator(
            name = "lecture_notice_id_seq_gen",
            sequenceName = "LECTURE_NOTICE_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "LECTURE_NOTICE_ID")
    private long lectureNoticeId;   //강의공지 글번호
    @Column(name = "LECTURE_ID")
    private long lectureId;   //강의번호
    @Column(name = "LECTURE_NOTICE_TITLE")
    private String lectureNoticeTitle;   //강의공지 제목
    @Column(name = "LECTURE_NOTICE_CONTENT")
    private String lectureNoticeContent;   //강의공지 내용
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;   //강의공지 작성일
    @Column(name = "READCOUNT")
    private int readcount;   //조회수

}
