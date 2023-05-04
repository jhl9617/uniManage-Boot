package org.webMonster.uniManageBoot.student.freeboard.entity;

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
@Table(name = "FREEBOARD")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class FreeBoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FREE_ID")
    private long free_id;   //자유게시판 번호
    @Column(name = "FREE_TITLE")
    private String free_title;   //자유게시판 제목
    @Column(name = "FREE_CONTENT")
    private String free_content;   //자유게시판 내용
    @Column(name = "CREATED_DATE")
    private LocalDateTime created_date;   //자유게시판 작성일
    @Column(name = "MEMBER_ID")
    private long member_id;   //자유게시판 작성자

}
