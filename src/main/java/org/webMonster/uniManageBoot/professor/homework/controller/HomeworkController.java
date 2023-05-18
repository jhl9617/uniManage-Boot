package org.webMonster.uniManageBoot.professor.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.homework.entity.HomeworkEntity;
import org.webMonster.uniManageBoot.professor.homework.entity.HomeworkFileEntity;
import org.webMonster.uniManageBoot.professor.homework.model.dto.HomeworkDto;
import org.webMonster.uniManageBoot.professor.homework.model.dto.HomeworkFileDto;
import org.webMonster.uniManageBoot.professor.homework.model.dto.HomeworkWithFileDto;
import org.webMonster.uniManageBoot.professor.homework.model.service.HomeworkService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    // 페이지 단위로 목록 조회
    @GetMapping("/eclass/lecture/homework/list")
    public Header<List<HomeworkDto>> homeworkList(
            @PageableDefault(sort = {"homework_id"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return homeworkService.getHomeworkList(pageable, searchCondition);
    }

    //게시글 선택 조회, 게시글 번호에 해당하는 파일까지 같이 조회
    @GetMapping("/eclass/lecture/homework/{id}")
    public HomeworkWithFileDto getHomeworkWithFile(@PathVariable Long id) {
        HomeworkWithFileDto response = new HomeworkWithFileDto();
        response.setHomework(homeworkService.getHomework(id));
        response.setHomeworkFile(homeworkService.getFile(id));
        return response;

    }
    //게시글 작성 -- 교수 기능 맵핑 수정해주세요
    @PostMapping("/eclass/lecture/homework")
    public HomeworkEntity create(@RequestBody HomeworkDto homeworkDto) {

        return homeworkService.create(homeworkDto);
    }

    // 게시글 수정 -- 교수 기능 맵핑 수정해주세요
    @PatchMapping("/eclass/lecture/homework")
    public HomeworkEntity update(@RequestBody HomeworkDto homeworkDto) {

        return homeworkService.update(homeworkDto);
    }

    //파일 업로드 저장 -- 교수 기능 맵핑 수정해주세요
    @PostMapping("/eclass/lecture/homework/{id}")
    public HomeworkFileEntity createFile(@PathVariable Long id, @RequestBody HomeworkFileDto homeworkfileDto) {

        return homeworkService.createFile(homeworkfileDto, id);
    }

    // 첨부파일 수정 -- 교수 기능 맵핑 수정해주세요
    @PatchMapping("/eclass/lecture/homework/{id}")
    public HomeworkFileEntity updateFile(@RequestBody HomeworkFileDto homeworkfileDto, @PathVariable Long id) {

        return homeworkService.updateFile(homeworkfileDto, id);
    }
    // 게시글, 첨부파일 삭제 -- 교수 기능 맵핑 수정해주세요
    @DeleteMapping("/eclass/lecture/homework/{id}")
    public void delete(@PathVariable Long id) {
        homeworkService.delete(id);
        homeworkService.deleteFile(id);


    }
}
