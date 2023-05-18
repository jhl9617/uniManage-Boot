package org.webMonster.uniManageBoot.professor.cancelledLecture.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.professor.cancelledLecture.entity.CancelledLectureEntity;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.ApplyDto;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto.CancelledLectureDto;
import org.webMonster.uniManageBoot.professor.cancelledLecture.model.service.CancelledLectureService;

@Slf4j
@CrossOrigin
@RestController
public class CancelledLectureController {
    private CancelledLectureService cancelledLectureService;

    //페이지 단위로 조회(페이징 처리)



    //휴강게시물 등록
    @PostMapping("/prof/lecture/cancelled/write")
    public CancelledLectureEntity create(@RequestBody CancelledLectureDto cancelledLectureDto){
        return cancelledLectureService.create(cancelledLectureDto);
    }

    //휴강게시글(승인여부) 수정
//    @PatchMapping ("/admin/manage/closelecture")
//    public CancelledLectureEntity update(@RequestBody ApplyDto applyDto){
//        return cancelledLectureService.update(applyDto);
//    }
}
