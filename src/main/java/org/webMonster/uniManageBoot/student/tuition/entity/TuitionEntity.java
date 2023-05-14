package org.webMonster.uniManageBoot.student.tuition.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TUITION")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class TuitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TUITION_ID")
    private long tuitionId;   //등록금 번호
    @Column(name = "MEMBER_ID")
    private long memberId;   //회원 아이디
    @Column(name = "TUITION_AMOUNT")
    private int tuitionAmount;   //등록금액
    @Column(name = "PAID")
    private char paid;   //납부여부
    @Column(name = "TUITION_TERM")
    private int tuitionTerm;   //등록금 학기
}
