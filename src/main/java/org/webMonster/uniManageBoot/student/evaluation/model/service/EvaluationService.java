package org.webMonster.uniManageBoot.student.evaluation.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.student.evaluation.entity.EvaluationEntity;
import org.webMonster.uniManageBoot.student.evaluation.model.dto.EvaluationDto;
import org.webMonster.uniManageBoot.student.evaluation.entity.EvaluationRepository;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;
    
    //교수의 강의평가 목록 조회
    public List<EvaluationDto> evaluationList(Long id) {
        return null;
    }

    
    //학생의 강의평가 등록
    public EvaluationEntity create(EvaluationDto evaluationDto) {
        EvaluationEntity entity = EvaluationEntity.builder()
                .evaluationId(evaluationDto.getEvaluationId())
                .lectureId(evaluationDto.getLectureId())
                .memberId(evaluationDto.getMemberId())
                .score1(evaluationDto.getScore1())
                .score2(evaluationDto.getScore2())
                .score3(evaluationDto.getScore3())
                .score4(evaluationDto.getScore4())
                .score5(evaluationDto.getScore5())
                .comments(evaluationDto.getComments())
                .build();
        return evaluationRepository.save(entity);
    }
}
