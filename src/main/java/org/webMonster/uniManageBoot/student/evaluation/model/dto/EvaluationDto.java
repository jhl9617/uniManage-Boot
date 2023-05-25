package org.webMonster.uniManageBoot.student.evaluation.model.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EvaluationDto {

    private long evaluationId;   //강의평가 번호
    private long memberId;   //회원 아이디
    private long lectureId;   //강의 아이디
    private int score1;   //1번 문항 점수
    private int score2;   //2번 문항 점수
    private int score3;   //3번 문항 점수
    private int score4;   //4번 문항 점수
    private int score5;   //5번 문항 점수
    private String comments;   //하고싶은 말
}
