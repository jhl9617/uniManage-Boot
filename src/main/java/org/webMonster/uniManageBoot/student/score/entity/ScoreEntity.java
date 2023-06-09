package org.webMonster.uniManageBoot.student.score.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SCORE")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "score_seq_gen")
    @SequenceGenerator(
            name = "score_seq_gen",
            sequenceName = "SCORE_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "SCORE_ID")
    private long scoreId;   //성적 번호
    @Column(name = "MEMBER_ID")
    private long memberId;   //회원 아이디
    @Column(name = "LECTURE_ID")
    private long lectureId;   //강의 아이디
    @Column(name = "MID_SCORE")
    private int midScore;   //중간고사 점수
    @Column(name = "FINAL_SCORE")
    private int finalScore;   //기말고사 점수
    @Column(name = "ASSIGN_SCORE")
    private int assignScore;   //과제 점수
    @Column(name = "TOTAL_SCORE")
    private int totalScore;   //학기 총점수

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", insertable = false, updatable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID", referencedColumnName = "LECTURE_ID", insertable = false, updatable = false)
    private LectureEntity lecture;

}
