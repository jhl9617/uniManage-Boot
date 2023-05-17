package org.webMonster.uniManageBoot.professor.lecture.controlller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.LectureDto;
import org.webMonster.uniManageBoot.professor.lecture.model.service.LectureService;
import org.webMonster.uniManageBoot.student.freeboard.model.service.FreeboardService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class LectureController {

    @Autowired
    private LectureService lectureService;
    @Autowired
    private FreeboardService freeboardService;

    //교직원 개설 강의 관리 리스트 조회
    @GetMapping("/admin/manage/lecture")
    public Header<List<LectureDto>> lectureList(
            @PageableDefault(sort = {"lectureId"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return lectureService.getLectureList(pageable, searchCondition);
    }

    //교직원 강의개설요청 관리 리스트 조회
    @GetMapping("/admin/manage/appliedlecture")
    public Header<List<LectureDto>> appliedlectureList(
            @PageableDefault(sort = {"lectureId"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return lectureService.getAppliedLectureList(pageable, searchCondition);
    }
    //Eclass 선택된 강의 정보 조회 - 강의 메인화면
    @GetMapping("/eclass/lecture/{id}")
    public LectureDto getLecture(@PathVariable Long id){

        return lectureService.getLecture(id);


    }
    //Eclass 선택된 강의 정보 조회 - 출력
    @GetMapping("/eclass/lecture/lectureinfo/{id}")
    public LectureDto getLectureinfo(@PathVariable Long id){
        return lectureService.getLecture(id);

    }
}
