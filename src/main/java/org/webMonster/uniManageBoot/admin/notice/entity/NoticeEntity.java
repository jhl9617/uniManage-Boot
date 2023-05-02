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
    private long notice_id;   //공지사항 번호
    @Column(name = "NOTICE_TITLE")
    private String notice_title;   //공지사항 제목
    @Column(name = "NOTICE_CONTENT")
    private String notice_content;   //공지사항 내용
    @Column(name = "MEMBER_ID")
    private long member_id;   //작성자
    @Column(name = "CREATED_DATE")
    private LocalDateTime created_date;   //등록일
    @Column(name = "READCOUNT")
    private int readcount;   //조회수
}
