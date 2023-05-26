package org.webMonster.uniManageBoot.student.freeboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "FREEBOARD_REP")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class FreeboardRepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FREE_REP_ID_SEQ")
    @SequenceGenerator(name = "FREE_REP_ID_SEQ", sequenceName = "FREE_REP_ID_SEQ", allocationSize = 1)
    @Column(name = "FREE_REP_ID")
    private long freeRepId;   //자유게시판 댓글 번호
    @Column(name = "FREE_ID")
    private long freeId;   //자유게시판 번호
    @Column(name = "FREE_REP_CONTENT")
    private String freeRepContent;   //댓글 내용
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;   //댓글 작성일
    @Column(name = "MEMBER_ID")
    private long memberId;   //댓글 작성자

    @ManyToOne
    @JoinColumn(name = "FREE_ID", referencedColumnName = "FREE_ID", insertable = false, updatable = false)
    private FreeboardEntity freeboard;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", insertable = false, updatable = false)
    private MemberEntity member;

}
