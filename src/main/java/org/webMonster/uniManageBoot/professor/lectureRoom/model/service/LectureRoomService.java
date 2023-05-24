package org.webMonster.uniManageBoot.professor.lectureRoom.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;

import org.webMonster.uniManageBoot.professor.lectureRoom.entity.*;
import org.webMonster.uniManageBoot.professor.lectureRoom.model.dto.LectureRoomDto;
import org.webMonster.uniManageBoot.professor.lectureRoom.model.dto.LectureRoomFileDto;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LectureRoomService {

    @Autowired
    private LectureRoomRepository lectureRoomRepository;

    @Autowired
    private LectureRoomFileRepository lectureRoomFileRepository;

    @Autowired
    private LectureRoomRepositoryCustom lectureRoomRepositoryCustom;
    
    // 강의자료 목록 조회
    public Header<List<LectureRoomDto>> getSourceList(Pageable pageable, SearchCondition searchCondition, Long id) {

        List<LectureRoomDto> list = new ArrayList<>();

        Page<LectureRoomEntity> lectureRoomEntities = lectureRoomRepositoryCustom.findAllBySearchCondition(pageable, searchCondition, id);

        for (LectureRoomEntity entity : lectureRoomEntities) {
            LectureRoomDto dto = LectureRoomDto.builder()
                    .lectureRoomId(entity.getLectureRoomId())
                    .lectureId(entity.getLectureId())
                    .memberId(entity.getMemberId())
                    .name(entity.getMember().getName())
                    .lectureRoomTitle(entity.getLectureRoomTitle())
                    .lectureRoomContent(entity.getLectureRoomContent())
                    .readcount(entity.getReadcount())
                    .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) lectureRoomEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }

    // 강의 자료 리스트 조회(페이징 x) - eclass 메인화면에서 사용
    public List<LectureRoomDto> getSourceList(Long id){
        List<LectureRoomDto> list = new ArrayList<>();
        List<LectureRoomEntity> entity = lectureRoomRepository.findByLectureId(id);
        for (LectureRoomEntity lentity : entity) {
            LectureRoomDto dto = LectureRoomDto.builder()
                    .lectureRoomId(lentity.getLectureRoomId())
                    .lectureId(lentity.getLectureId())
                    .memberId(lentity.getMemberId())
                    .lectureRoomTitle(lentity.getLectureRoomTitle())
                    .lectureRoomContent(lentity.getLectureRoomContent())
                    .readcount(lentity.getReadcount())
                    .createdDate(lentity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();
            list.add(dto);
        }
        return list;
    }
    
    // 강의 자료 선택 조회
    public LectureRoomDto getSource(Long id) {
        LectureRoomEntity entity = lectureRoomRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return LectureRoomDto.builder()
                .lectureRoomId(entity.getLectureRoomId())
                .lectureId(entity.getLectureId())
                .memberId(entity.getMemberId())
                .name(entity.getMember().getName())
                .lectureRoomTitle(entity.getLectureRoomTitle())
                .lectureRoomContent(entity.getLectureRoomContent())
                .readcount(entity.getReadcount())
                .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();


    }
    // 선택된 강의자료의 첨부파일 경로 조회
    public LectureRoomFileDto getFile(Long id) {

       LectureRoomFileEntity entity = lectureRoomFileRepository.findByLectureRoomId(id);

            return LectureRoomFileDto.builder()
                    .lectureRoomId(entity.getLectureRoomId())
                    .fileName(entity.getFileName())
                    .fileRename(entity.getFileRename())
                    .build();



    }

    /**
     * 강의자료 등록
     */
    public LectureRoomEntity create(LectureRoomDto lectureRoomDto) {
        LectureRoomEntity entity = LectureRoomEntity.builder()
                .lectureRoomId(lectureRoomDto.getLectureRoomId())
                .lectureId(lectureRoomDto.getLectureId())
                .memberId(lectureRoomDto.getMemberId())
                .lectureRoomTitle(lectureRoomDto.getLectureRoomTitle())
                .lectureRoomContent(lectureRoomDto.getLectureRoomContent())
                .createdDate(LocalDateTime.now())
                .build();
        return lectureRoomRepository.save(entity);
    }

    



    /**
     * 강의자료 수정
     */
    public LectureRoomEntity update(LectureRoomDto lectureRoomDto) {
        LectureRoomEntity entity = lectureRoomRepository.findById(lectureRoomDto.getLectureRoomId()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setLectureRoomTitle(lectureRoomDto.getLectureRoomTitle());
        entity.setLectureRoomContent(lectureRoomDto.getLectureRoomContent());
        return lectureRoomRepository.save(entity);
    }

    /**
     * 강의자료 삭제
     */
    public void delete(Long id) {
        LectureRoomEntity entity = lectureRoomRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        lectureRoomRepository.delete(entity);

    }

    //강의자료 첨부파일 추가
    public LectureRoomFileEntity createFile(LectureRoomFileDto lectureRoomFileDto, Long id) {
        LectureRoomFileEntity entity = LectureRoomFileEntity.builder()
                .lectureRoomId(id)
                .fileName(lectureRoomFileDto.getFileName())
                .fileRename(lectureRoomFileDto.getFileRename())
                .build();
        return lectureRoomFileRepository.save(entity);
    }

    //강의자료 첨부파일 수정
    public LectureRoomFileEntity updateFile(LectureRoomFileDto lectureRoomFileDto) {
        LectureRoomFileEntity entity = lectureRoomFileRepository.findById(lectureRoomFileDto.getLectureRoomId()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setFileName(lectureRoomFileDto.getFileName());
        entity.setFileRename(lectureRoomFileDto.getFileRename());
        return lectureRoomFileRepository.save(entity);
    }
    
    // 첨부파일 삭제
    public void deleteFile(Long id) {
        LectureRoomFileEntity fileEntity = lectureRoomFileRepository.findByLectureRoomId(id);
        lectureRoomFileRepository.delete(fileEntity);
    }




}
