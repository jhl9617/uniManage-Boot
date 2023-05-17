package org.webMonster.uniManageBoot.student.freeboard.entity;

import lombok.*;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "FREEBOARD")  //테이블 자동 생성시키는 어노테이션임
@Entity
@Setter
@Getter
public class FreeboardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FREE_ID_SEQ")
    @SequenceGenerator(name = "FREE_ID_SEQ", sequenceName = "FREE_ID_SEQ", allocationSize = 1)
    @Column(name = "FREE_ID")
    private long freeId;   //자유게시판 번호
    @Column(name = "FREE_TITLE")
    private String freeTitle;   //자유게시판 제목
    @Column(name = "FREE_CONTENT")
    private String freeContent;   //자유게시판 내용
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;   //자유게시판 작성일
    @Column(name = "MEMBER_ID")
    private long memberId;   //자유게시판 작성자
//    @Column(name = "NAME")
//    private String name; // 자유게시판 작성자 이름

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", insertable = false, updatable = false)
    private MemberEntity member;

    @OneToMany(mappedBy = "freeboard")
    private List<FreeboardRepEntity> freeboardRepEntities = new ArrayList<>();

}
