package org.webMonster.uniManageBoot.student.freeboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardRepEntity;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardDto;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardRepDto;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardWithRepDto;
import org.webMonster.uniManageBoot.student.freeboard.model.service.FreeboardService;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class FreeboardController {
    @Autowired
    private FreeboardService freeboardService;

//    @GetMapping("/board/list")
//    public List<BoardDto> boardList() {
//        return boardService.getBoardList();
//    }

    // 페이지 단위로 목록 조회
    @GetMapping("/eclass/lecture/board/list")
    public Header<List<FreeboardDto>> freeboardList(
            @PageableDefault(sort = {"free_id"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return freeboardService.getBoardList(pageable, searchCondition);
    }
    // 게시글 선택 조회
//    @GetMapping("/Eclass/board/{id}")
//    public FreeboardDto getFreeBoard(@PathVariable Long id) {
//
//        return freeboardService.getBoard(id);
//    }
    //게시글 선택 조회, 게시글 번호에 해당하는 댓글리스트 조회
    @GetMapping("/eclass/lecture/board/{id}")
    public FreeboardWithRepDto getFreeBoardWithRep(@PathVariable Long id) {
        FreeboardWithRepDto response = new FreeboardWithRepDto();
        response.setFreeboard(freeboardService.getBoard(id));
        response.setFreeboardReps(freeboardService.getBoardRep(id));
        return response;

    }
     //게시글 작성
    @PostMapping("/eclass/lecture/board")
    public FreeboardEntity create(@RequestBody FreeboardDto freeboardDto) {

        return freeboardService.create(freeboardDto);
    }
    //댓글 작성
    @PostMapping("/eclass/lecture/board/{id}")
    public FreeboardRepEntity createRep(@PathVariable Long id, @RequestBody FreeboardRepDto freeboardRepDto) {

        return freeboardService.createRep(freeboardRepDto, id);
    }
    // 게시글 수정
    @PatchMapping("/eclass/lecture/board")
    public FreeboardDto update(@RequestBody FreeboardDto freeboardDto) {

        FreeboardEntity entity = freeboardService.update(freeboardDto);
        return FreeboardDto.modifyFreeboard(entity);
    }
    // 게시글, 댓글 삭제
    @DeleteMapping("/eclass/lecture/board/{id}")
    public void delete(@PathVariable Long id, @RequestParam(name="id", required=false) Long repId) {
        if(repId != null){
            freeboardService.deleteRep(repId);
        } else {
            freeboardService.delete(id);
        }
    }







}