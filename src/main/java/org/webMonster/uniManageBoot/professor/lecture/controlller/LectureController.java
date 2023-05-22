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
import org.webMonster.uniManageBoot.professor.homework.model.service.HomeworkService;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.LectureDto;
import org.webMonster.uniManageBoot.professor.lecture.model.dto.LectureMainDto;
import org.webMonster.uniManageBoot.professor.lecture.model.service.LectureService;
import org.webMonster.uniManageBoot.professor.lectureNotice.model.service.LectureNoticeService;
import org.webMonster.uniManageBoot.professor.lectureRoom.model.service.LectureRoomService;
import org.webMonster.uniManageBoot.student.freeboard.model.service.FreeboardService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class LectureController {
    @Autowired
    private final LectureService lectureService;
    @Autowired
    private final FreeboardService freeboardService;
    @Autowired
    private final LectureNoticeService lectureNoticeService;
    @Autowired
    private final LectureRoomService lectureRoomService;
    @Autowired
    private final HomeworkService homeworkService;


    //교직원 개설 강의 관리 리스트 조회
    @GetMapping("/admin/manage/lecture")
    public Header<List<LectureDto>> lectureList(
            @PageableDefault(sort = {"lectureId"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return lectureService.getLectureList(pageable, searchCondition);
    }

    //교직원 개설 강의 관리 상세보기글 조회
    @GetMapping("/admin/manage/lecture/{id}")
    public LectureDto getAdminLecture(@PathVariable Long id) { return lectureService.getLecture(id); }



    //교직원 강의개설요청 관리 리스트 조회
    @GetMapping("/admin/manage/appliedlecture")
    public Header<List<LectureDto>> appliedlectureList(
            @PageableDefault(sort = {"lectureId"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return lectureService.getAppliedLectureList(pageable, searchCondition);
    }

    //교직원 강의개설요청 관리 상세보기글 조회
    @GetMapping("/admin/manage/appliedlecture/{id}")
    public LectureDto getAppliedLecture(@PathVariable Long id) { return lectureService.getLecture(id); }


    //Eclass 선택된 강의 정보를 이용해 조회 - 강의 메인화면
    @GetMapping("/eclass/lecture/{id}")
    public LectureMainDto getLectureMain(@PathVariable Long id){
        LectureMainDto response = new LectureMainDto();
        response.setLectureDto(lectureService.getLecture(id));
        response.setFreeboardDto(freeboardService.getBoardList());
        response.setLectureNoticeDto(lectureNoticeService.getLectureNoticeList(id));
        response.setLectureRoomDto(lectureRoomService.getSourceList(id));
        response.setHomeworkDto(homeworkService.getHomeworkList(id));
        return response;
    }
//    public LectureDto getLecture(@PathVariable Long id){
//        return lectureService.getLecture(id);
//    }
    //Eclass 선택된 강의 정보 조회 - 출력
    @GetMapping("/eclass/lecture/lectureinfo/{id}")
    public LectureDto getLectureinfo(@PathVariable Long id){
        return lectureService.getLecture(id);

    }





}
