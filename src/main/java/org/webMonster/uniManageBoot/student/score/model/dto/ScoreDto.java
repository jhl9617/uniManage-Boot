package org.webMonster.uniManageBoot.student.score.model.dto;

import lombok.*;
import org.webMonster.uniManageBoot.student.score.entity.ScoreEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class ScoreDto {

    private long scoreId;
    private long memberId;
    private long lectureId;
    private int midScore;
    private int finalScore;
    private int assignScore;
    private int totalScore;

    //멤버 테이블 조인
    private String name;

    //강의 테이블 조인
    private String lectureTitle;
    private int credit;

//    public static ScoreDto fromEntity(ScoreEntity scoreEntity) {
//        ScoreDto scoreDto = new ScoreDto();
//        scoreDto.setScoreId(scoreDto.getScoreId());
//        scoreDto.setMemberId(scoreDto.getMemberId());
//        scoreDto.setLectureId(scoreDto.getLectureId());
//        scoreDto.setMidScore(scoreDto.getMidScore());
//        scoreDto.setFinalScore(scoreDto.getFinalScore());
//        scoreDto.setAssignScore(scoreDto.getAssignScore());
//        scoreDto.setTotalScore(scoreDto.getTotalScore());
//        return scoreDto;
//    }
}
