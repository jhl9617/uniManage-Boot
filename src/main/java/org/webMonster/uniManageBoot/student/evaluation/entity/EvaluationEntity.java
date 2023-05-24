package org.webMonster.uniManageBoot.student.evaluation.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "EVALUATION")  //테이블 자동 생성시키는 어노테이션임
@Entity
@Getter
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVALUATION_ID_SEQ_GEN")
    @SequenceGenerator(name = "EVALUATION_ID_SEQ_GEN", sequenceName = "EVALUATION_ID_SEQ", allocationSize = 1)
    @Column(name = "EVALUATION_ID")
    private long evaluationId;   //강의평가 번호
    @Column(name = "MEMBER_ID")
    private long memberId;   //회원 아이디
    @Column(name = "LECTURE_ID")
    private long lectureId;   //강의 아이디
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
