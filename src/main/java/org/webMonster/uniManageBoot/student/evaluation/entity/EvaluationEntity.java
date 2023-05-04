package org.webMonster.uniManageBoot.student.evaluation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "EVALUATION")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVALUATION_ID")
    private long evaluation_id;   //강의평가 번호
    @Column(name = "MEMBER_ID")
    private long member_id;   //회원 아이디
    @Column(name = "LECTURE_ID")
    private long lecture_id;   //강의 아이디
    @Column(name = "SCORE1")
    private int score1;   //1번 문항 점수
    @Column(name = "SCORE2")
    private int score2;   //2번 문항 점수
    @Column(name = "SCORE3")
    private int score3;   //3번 문항 점수
    @Column(name = "SCORE4")
    private int score4;   //4번 문항 점수
    @Column(name = "SCORE5")
    private int score5;   //5번 문항 점수
    @Column(name = "COMMENTS")
    private String comments;   //하고싶은 말
}
