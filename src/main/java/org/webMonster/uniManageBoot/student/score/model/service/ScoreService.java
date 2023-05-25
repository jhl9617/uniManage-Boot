package org.webMonster.uniManageBoot.student.score.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.student.score.entity.ScoreEntity;
import org.webMonster.uniManageBoot.student.score.entity.ScoreRepository;
import org.webMonster.uniManageBoot.student.score.entity.ScoreRepositoryCustom;
import org.webMonster.uniManageBoot.student.score.model.dto.ScoreDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final ScoreRepositoryCustom scoreRepositoryCustom;

    //교직원 학생관리 학생정보상세 성적 리스트 조회
    public Header<List<ScoreDto>> getStudentScoreList(Pageable pageable, SearchCondition searchCondition, Long memberId) {
        List<ScoreDto> dtos = new ArrayList<>();

        Page<ScoreEntity> ScoreEntities = scoreRepositoryCustom.findByMemberId(pageable, memberId, searchCondition);
        for (ScoreEntity entity : ScoreEntities) {
            ScoreDto dto = ScoreDto.builder()
                    .scoreId(entity.getScoreId())
                    .memberId(entity.getMemberId())
                    .lectureId(entity.getLectureId())
                    .midScore(entity.getMidScore())
                    .finalScore(entity.getFinalScore())
                    .assignScore(entity.getAssignScore())
                    .totalScore(entity.getTotalScore())
                    .name(entity.getMember().getName())
                    .lectureTitle(entity.getLecture().getLectureTitle())
                    .build();
            dtos.add(dto);
        }

        return Header.OK(dtos);
    }

    //학생 학생정보시스템 수강성적조회 리스트 출력용
    public List<ScoreDto> getScoreList(Long id) {
        List<ScoreDto> list = new ArrayList<>();
        List<ScoreEntity> entity = scoreRepository.findByMemberId(id);
        for (ScoreEntity sentity : entity) {
            ScoreDto dto = ScoreDto.builder()
                    .scoreId(sentity.getScoreId())
                    .memberId(sentity.getMemberId())
                    .lectureId(sentity.getLectureId())
                    .midScore(sentity.getMidScore())
                    .finalScore(sentity.getFinalScore())
                    .assignScore(sentity.getAssignScore())
                    .totalScore(sentity.getTotalScore())
                    .lectureTitle(sentity.getLecture().getLectureTitle())
                    .credit(sentity.getLecture().getCredit())
                    .build();
            list.add(dto);
        }
        return list;
    }
}
