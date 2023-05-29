package org.webMonster.uniManageBoot.professor.lectureRoom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureRoom.entity.LectureRoomEntity;
import org.webMonster.uniManageBoot.professor.lectureRoom.entity.LectureRoomFileEntity;
import org.webMonster.uniManageBoot.professor.lectureRoom.model.dto.LectureRoomDto;
import org.webMonster.uniManageBoot.professor.lectureRoom.model.dto.LectureRoomFileDto;
import org.webMonster.uniManageBoot.professor.lectureRoom.model.dto.LectureRoomWithFileDto;
import org.webMonster.uniManageBoot.professor.lectureRoom.model.service.LectureRoomService;


import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class LectureRoomController {

    @Autowired
    private LectureRoomService lectureRoomService;

    // 페이지 단위로 목록 조회
    @GetMapping("/eclass/lecture/source/list")
    public Header<List<LectureRoomDto>> sourceList(
            @PageableDefault(sort = {"lecture_room_id"}) Pageable pageable,
            SearchCondition searchCondition,
            @RequestParam("lecture_id") Long id
    ) {
        return lectureRoomService.getSourceList(pageable, searchCondition, id);
    }

    //게시글 선택 조회, 게시글 번호에 해당하는 파일까지 같이 조회
    @GetMapping("/eclass/lecture/source/detail")
    public LectureRoomWithFileDto getLectureRoomWithFile(@RequestParam("lecture_room_id") Long id) {
        LectureRoomWithFileDto response = new LectureRoomWithFileDto();
        response.setLectureRoom(lectureRoomService.getSource(id));
        response.setLectureRoomFile(lectureRoomService.getFile(id));
        return response;

    }

    // 페이지 단위로 목록 조회
    @GetMapping("/prof/lecture/reference/list")
    public Header<List<LectureRoomDto>> profReferenceList(
            @PageableDefault(sort = {"lecture_room_id"}) Pageable pageable,
            SearchCondition searchCondition,
            @RequestParam("lecture_id") Long id
    ) {
        return lectureRoomService.getSourceList(pageable, searchCondition, id);
    }

    //게시글 선택 조회, 게시글 번호에 해당하는 파일까지 같이 조회
    @GetMapping("/prof/lecture/reference/detail")
    public LectureRoomWithFileDto getProfLectureRoomWithFile(@RequestParam("lecture_room_id") Long id) {
        LectureRoomWithFileDto response = new LectureRoomWithFileDto();
        response.setLectureRoom(lectureRoomService.getSource(id));
        response.setLectureRoomFile(lectureRoomService.getFile(id));
        return response;

    }

    //게시글 작성
    @PostMapping("/prof/lecture/reference")
    public LectureRoomEntity create(@RequestBody LectureRoomDto lectureRoomDto) {

        return lectureRoomService.create(lectureRoomDto);
    }

    // 게시글 수정
    @PatchMapping("/prof/lecture/reference")
    public LectureRoomEntity update(@RequestBody LectureRoomDto lectureRoomDto) {

        return lectureRoomService.update(lectureRoomDto);
    }

    //파일 업로드 저장 -- 교수 기능 구현시 메소드 수정해주세요
    @PostMapping("/prof/lecture/reference/{id}")
    public LectureRoomFileEntity createFile(@PathVariable Long id, @RequestBody LectureRoomFileDto lectureRoomFileDto) {

        return lectureRoomService.createFile(lectureRoomFileDto, id);
    }

    // 첨부파일 수정 -- 교수 기능 구현시 메소드 수정해주세요
    @PatchMapping("/prof/lecture/reference/{id}")
    public LectureRoomFileEntity updateFile(@RequestBody LectureRoomFileDto lectureRoomFileDto, @PathVariable Long id) {

        return lectureRoomService.updateFile(lectureRoomFileDto);
    }

    // 게시글, 첨부파일 삭제 -- 교수 기능 구현시 메소드 수정해주세요
    @DeleteMapping("/prof/lecture/reference/{id}")
    public void delete(@PathVariable Long id) {
        lectureRoomService.delete(id);
        lectureRoomService.deleteFile(id);
    }

}
