package org.webMonster.uniManageBoot.student.freeboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardRepEntity;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardDto;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardRepDto;
import org.webMonster.uniManageBoot.student.freeboard.model.service.FreeboardService;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class FreeboardController {
    private final FreeboardService freeboardService;

//    @GetMapping("/board/list")
//    public List<BoardDto> boardList() {
//        return boardService.getBoardList();
//    }

    // 페이지 단위로 목록 조회
    @GetMapping("/eclass/board/list")
    public Header<List<FreeboardDto>> freeboardList(
            @PageableDefault(sort = {"id"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return freeboardService.getBoardList(pageable, searchCondition);
    }
    // 게시글 선택 조회
    @GetMapping("/eclass/board/{id}")
    public FreeboardDto getFreeBoard(@PathVariable Long id) {

        return freeboardService.getBoard(id);
    }
    // 게시글 작성
    @PostMapping("/eclass/board")
    public FreeboardEntity create(@RequestBody FreeboardDto freeboardDto) {

        return freeboardService.create(freeboardDto);
    }
    // 게시글 수정
    @PatchMapping("/eclass/board/{id}")
    public FreeboardEntity update(@RequestBody FreeboardDto freeboardDto) {

        return freeboardService.update(freeboardDto);
    }
    // 게시글 삭제
    @DeleteMapping("/eclass/board/{id}")
    public void delete(@PathVariable Long id) {

        freeboardService.delete(id);
    }


    // 댓글 작성
    @PostMapping("/eclass/board/{id}")
    public FreeboardRepEntity createRep(@RequestBody FreeboardRepDto freeboardRepDto) {

        return freeboardService.createRep(freeboardRepDto);
    }
    // 댓글 수정
    @PatchMapping("/eclass/board")
    public FreeboardRepEntity update(@RequestBody FreeboardRepDto freeboardRepDto) {

        return freeboardService.updateRep(freeboardRepDto);
    }
    // 댓글 삭제
    @DeleteMapping("/eclass/board/{id}/del")
    public void deleteRep(@PathVariable Long id) {

        freeboardService.deleteRep(id);
    }




}