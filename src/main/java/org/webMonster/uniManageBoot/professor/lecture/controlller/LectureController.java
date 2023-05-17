package org.webMonster.uniManageBoot.professor.lecture.controlller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.LectureDto;
import org.webMonster.uniManageBoot.professor.lecture.model.service.LectureService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class LectureController {
    private final LectureService lectureService;

    //교직원 개설 강의 관리 리스트 조회
    @GetMapping("/admin/manage/lecture")
    public Header<List<LectureDto>> lectureList(
            @PageableDefault(sort = {"lectureId"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return lectureService.getLectureList(pageable, searchCondition);
    }
}
