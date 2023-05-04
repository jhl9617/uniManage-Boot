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
@Table(name = "TOTALSCORE")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class TotalScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private long member_id;   //회원 아이디
    @Column(name = "TOTAL_AVERAGE")
    private int total_average;   //전체학기 평점
    @Column(name = "MAX_CREDIT")
    private int max_credit;   //최대 이수학점
    @Column(name = "NOW_CREDIT")
    private int now_credit;   //현재 이수학점

}
