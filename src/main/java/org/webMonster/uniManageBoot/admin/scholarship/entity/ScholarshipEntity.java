package org.webMonster.uniManageBoot.admin.scholarship.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SCHOLARSHIP")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
public class ScholarshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHO_ID")
    private long scho_id;   //장학금 번호
    @Column(name = "SCHO_TERM")
    private int scho_term;   //장학금 학기
    @Column(name = "SCHO_NAME")
    private String scho_name;   //장학금명
    @Column(name = "AMOUNT")
    private int amount;   //장학금액
    @Column(name = "MEMBER_ID")
    private long member_id;   //멤버 아이디

}
