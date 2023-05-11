package org.webMonster.uniManageBoot.student.freeboard.model.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardRepEntity;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardRepository;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardRepRepository;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardRepositoryCustom;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardDto;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardRepDto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FreeboardService {

    private final FreeboardRepository freeboardRepository;
    private final FreeboardRepRepository freeboardRepRepository;
    private final FreeboardRepositoryCustom freeboardRepositoryCustom;

    /**
     * 게시글 목록 가져오기(페이징 처리를 포함)
     */

    public Header<List<FreeboardDto>> getBoardList(Pageable pageable, SearchCondition searchCondition) {
        List<FreeboardDto> list = new ArrayList<>();

        Page<FreeboardEntity> boardEntities = freeboardRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (FreeboardEntity entity : boardEntities) {
            FreeboardDto dto = FreeboardDto.builder()
                    .freeId(entity.getFreeId())
                    .memberId(entity.getMemberId())
                    .freeTitle(entity.getFreeTitle())
                    .freeContent(entity.getFreeContent())
                    .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) boardEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }


    /**
     * 게시글 목록 가져오기
     */

//    public List<BoardDto> getBoardList() {
//        List<BoardEntity> boardEntities = boardRepository.findAll();
//        List<BoardDto> list = new ArrayList<>();
//
//        for (BoardEntity entity : boardEntities) {
//            BoardDto dto = BoardDto.builder()
//                    .idx(entity.getIdx())
//                    .author(entity.getAuthor())
//                    .title(entity.getTitle())
//                    .contents(entity.getContents())
//                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
//                    .build();
//
//            list.add(dto);
//        }
//
//        return list;
//    }


    /**
     * 게시글 가져오기
     */
    public FreeboardDto getBoard(Long id) {
        FreeboardEntity entity = freeboardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return FreeboardDto.builder()
                .freeId(entity.getFreeId())
                .memberId(entity.getMemberId())
                .freeTitle(entity.getFreeTitle())
                .freeContent(entity.getFreeContent())
                .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();

    }

    /**
     * 게시글 등록
     */
    public FreeboardEntity create(FreeboardDto freeboardDto) {
        FreeboardEntity entity = FreeboardEntity.builder()
                .freeId(freeboardDto.getFreeId())
                .memberId(freeboardDto.getMemberId())
                .freeTitle(freeboardDto.getFreeTitle())
                .freeContent(freeboardDto.getFreeContent())
                .createdDate(LocalDateTime.now())
                .build();
        return freeboardRepository.save(entity);
    }

    /**
     * 게시글 수정
     */
    public FreeboardEntity update(FreeboardDto freeboardDto) {
        FreeboardEntity entity = freeboardRepository.findById(freeboardDto.getFreeId()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setFreeTitle(freeboardDto.getFreeTitle());
        entity.setFreeContent(freeboardDto.getFreeContent());
        return freeboardRepository.save(entity);
    }

    /**
     * 게시글 삭제
     */
    public void delete(Long id) {
        FreeboardEntity entity = freeboardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        freeboardRepository.delete(entity);
    }

    /**
     * 댓글 등록
     */
    public FreeboardRepEntity createRep(FreeboardRepDto freeboardRepDto) {
        FreeboardRepEntity entity = FreeboardRepEntity.builder()
                .freeId(freeboardRepDto.getFreeId())
                .freeRepId(freeboardRepDto.getFreeRepId())
                .memberId(freeboardRepDto.getMemberId())
                .freeRepContent(freeboardRepDto.getFreeRepContent())
                .createdDate(LocalDateTime.now())
                .build();
        return freeboardRepRepository.save(entity);
    }

    /**
     * 댓글 수정
     */
    public FreeboardRepEntity updateRep(FreeboardRepDto freeboardRepDto) {
        FreeboardRepEntity entity = freeboardRepRepository.findById(freeboardRepDto.getFreeId()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setFreeRepContent(freeboardRepDto.getFreeRepContent());

        return freeboardRepRepository.save(entity);
    }

    /**
     * 댓글 삭제
     */
    public void deleteRep(Long id) {
        FreeboardRepEntity entity = freeboardRepRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        freeboardRepRepository.delete(entity);
    }

}