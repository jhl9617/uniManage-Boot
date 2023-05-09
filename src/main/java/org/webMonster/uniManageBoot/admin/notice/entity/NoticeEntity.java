package org.webMonster.uniManageBoot.admin.notice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "NOTICE")
@Entity
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_ID")
    private long noticeId;   //공지사항 번호
    @Column(name = "NOTICE_TITLE")
    private String noticeTitle;   //공지사항 제목
    @Column(name = "NOTICE_CONTENT")
    private String noticeContent;   //공지사항 내용
    @Column(name = "MEMBER_ID")
    private long memberId;   //작성자
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;   //등록일
    @Column(name = "READCOUNT")
    private int readcount;   //조회수
}
