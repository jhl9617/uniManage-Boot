package org.webMonster.uniManageBoot.student.score.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.student.score.model.dto.ScoreDto;
import org.webMonster.uniManageBoot.student.score.model.service.ScoreService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ScoreController {
    private final ScoreService scoreService;


    //교직원 학생관리 학생정보상세 성적 리스트 조회
    @GetMapping("/admin/manage/student/score/{member_id}")
    public Header<List<ScoreDto>> studentScoreList(
            @PageableDefault(sort = {"scoreId"}) Pageable pageable,
            SearchCondition searchCondition,
            @PathVariable("member_id") Long memberId
    ) {
        return scoreService.getStudentScoreList(pageable, searchCondition, memberId);
    }
}
