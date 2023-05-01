package org.webMonster.uniManageBoot.board.controller;

import org.webMonster.uniManageBoot.board.entity.BoardEntity;
import org.webMonster.uniManageBoot.board.model.dto.BoardDto;
import org.webMonster.uniManageBoot.board.model.service.BoardService;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class BoardController {
    private final BoardService boardService;

/*
    @GetMapping("/board/list")
    public List<BoardDto> boardList() { return boardService.getBoardList(); }
*/

    //페이지 단위로 목록 조회
    @GetMapping("/board/list")
    public Header<List<BoardDto>> boardList(
            @PageableDefault(sort = {"idx"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return boardService.getBoardList(pageable, searchCondition);
    }

    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping("/board")
    public BoardEntity create(@RequestBody BoardDto boardDto) {
        return boardService.create(boardDto);
    }

    @PatchMapping("/board")
    public BoardEntity update(@RequestBody BoardDto boardDto) {
        return boardService.update(boardDto);
    }

    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }


}
