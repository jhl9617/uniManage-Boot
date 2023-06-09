package org.webMonster.uniManageBoot.student.freeboard.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.student.freeboard.entity.*;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardDto;
import org.webMonster.uniManageBoot.student.freeboard.model.dto.FreeboardRepDto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FreeboardService {

    @Autowired
    private FreeboardRepository freeboardRepository;
    @Autowired
    private FreeboardRepRepository freeboardRepRepository;
    @Autowired
    private FreeboardRepositoryCustom freeboardRepositoryCustom;


    /**
     * 게시글 목록 가져오기(페이징 처리를 포함)
     */

    public Header<List<FreeboardDto>> getBoardList(Pageable pageable, SearchCondition searchCondition) {

        List<FreeboardDto> list = new ArrayList<>();

        Page<FreeboardEntity> boardEntities = freeboardRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);

        for (FreeboardEntity entity : boardEntities) {
            FreeboardDto dto = FreeboardDto.builder()
                    .freeId(entity.getFreeId())
                    .name(entity.getMember().getName())
                    .freeTitle(entity.getFreeTitle())
                    .freeContent(entity.getFreeContent())
                    .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
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

    // 게시글 목록 가져오기(페이징 x)
    public List<FreeboardDto> getBoardList(){
        List<FreeboardDto> list = new ArrayList<>();
        List<FreeboardEntity> entity = freeboardRepository.findAll();
        for (FreeboardEntity fentity : entity) {
            FreeboardDto dto = FreeboardDto.builder()
                    .freeId(fentity.getFreeId())
                    .name(fentity.getMember().getName())
                    .freeTitle(fentity.getFreeTitle())
                    .freeContent(fentity.getFreeContent())
                    .createdDate(fentity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();
            list.add(dto);
        }
        return list;

    }

    /**
     * 게시글 가져오기
     */
    public FreeboardDto getBoard(Long id) {
        FreeboardEntity entity = freeboardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return FreeboardDto.builder()
                .freeId(entity.getFreeId())
                .name(entity.getMember().getName())
                .freeTitle(entity.getFreeTitle())
                .freeContent(entity.getFreeContent())
                .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .memberId(entity.getMemberId())
                .build();


    }

    public List<FreeboardRepDto> getBoardRep(Long id) {
        List<FreeboardRepDto> list = new ArrayList<>();
        List<FreeboardRepEntity> entity = freeboardRepRepository.findByFreeId(id);
        for (FreeboardRepEntity Repentity : entity) {
            FreeboardRepDto dto = FreeboardRepDto.builder()
                    .name(Repentity.getMember().getName())
                    .freeId(Repentity.getFreeId())
                    .freeRepId(Repentity.getFreeRepId())
                    .memberId(Repentity.getMemberId())
                    .freeRepContent(Repentity.getFreeRepContent())
                    .createdDate(Repentity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();
            list.add(dto);
        }
        return list;

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
     * 게시글 삭제, 작성된 댓글이 있으면 같이 삭제
     */
    public void delete(Long id) {
        List<FreeboardRepEntity> repEntities = freeboardRepRepository.findByFreeId(id);
        freeboardRepRepository.deleteAll(repEntities);
        FreeboardEntity entity = freeboardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        freeboardRepository.delete(entity);
    }

    /**
     * 댓글 등록
     */
    public FreeboardRepEntity createRep(FreeboardRepDto freeboardRepDto, Long id) {
        FreeboardRepEntity entity = FreeboardRepEntity.builder()
                .freeId(id)
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