package org.webMonster.uniManageBoot.student.totalScore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TOTAL_SCORE")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class TotalScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private long memberId;   //회원 아이디
    @Column(name = "TOTAL_AVERAGE")
    private int totalAverage;   //전체학기 평점
    @Column(name = "MAX_CREDIT")
    private int maxCredit;   //최대 이수학점
    @Column(name = "NOW_CREDIT")
    private int nowCredit;   //현재 이수학점

}
