package org.webMonster.uniManageBoot.student.score.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SCORE")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCORE_ID")
    private long score_id;   //성적 번호
    @Column(name = "MEMBER_ID")
    private long member_id;   //회원 아이디
    @Column(name = "LECTURE_ID")
    private long lecture_id;   //강의 아이디
    @Column(name = "MID_SCORE")
    private int mid_score;   //중간고사 점수
    @Column(name = "FINAL_SCORE")
    private int final_score;   //기말고사 점수
    @Column(name = "ASSIGN_SCORE")
    private int assign_score;   //과제 점수
    @Column(name = "TOTAL_SCORE")
    private int total_score;   //학기 총점수

}
