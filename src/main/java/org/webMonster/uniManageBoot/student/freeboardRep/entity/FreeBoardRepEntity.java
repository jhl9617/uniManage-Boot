package org.webMonster.uniManageBoot.student.freeboardRep.entity;

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
@Table(name = "FREEBOARD_REP")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
public class FreeBoardRepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FREE_REP_ID")
    private long free_rep_id;   //자유게시판 댓글 번호
    @Column(name = "FREE_ID")
    private long free_id;   //자유게시판 번호
    @Column(name = "FREE_REP_CONTENT")
    private String free_rep_content;   //댓글 내용
    @Column(name = "CREATED_DATE")
    private LocalDateTime created_date;   //댓글 작성일
    @Column(name = "MEMBER_ID")
    private long member_id;   //댓글 작성자

}
