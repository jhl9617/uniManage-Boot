package org.webMonster.uniManageBoot.professor.homework.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.homework.entity.*;
import org.webMonster.uniManageBoot.professor.homework.model.dto.HomeworkDto;
import org.webMonster.uniManageBoot.professor.homework.model.dto.HomeworkFileDto;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private HomeworkRepositoryCustom homeworkRepositoryCustom;
    @Autowired
    private HomeworkFileRepository homeworkFileRepository;

    //과제 리스트 조회
    public Header<List<HomeworkDto>> getHomeworkList(Pageable pageable, SearchCondition searchCondition, Long id) {
        List<HomeworkDto> list = new ArrayList<>();

        Page<HomeworkEntity> homeworkEntities = homeworkRepositoryCustom.findAllBySearchCondition(pageable, searchCondition, id);

        for (HomeworkEntity entity : homeworkEntities) {
            HomeworkDto dto = HomeworkDto.builder()
                    .homeworkId(entity.getHomeworkId())
                    .memberId(entity.getMemberId())
                    .lectureId(entity.getLectureId())
                    .homeworkName(entity.getHomeworkName())
                    .homeworkContent(entity.getHomeworkContent())
                    .submitted(entity.getSubmitted())
                    .deadline(entity.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) homeworkEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);
    }

    //과제 리스트 조회(페이징 x )
    public List<HomeworkDto> getHomeworkList(Long id){
        List<HomeworkDto> list = new ArrayList<>();
        List<HomeworkEntity> entity = homeworkRepository.findByLectureId(id);
        for (HomeworkEntity hentity : entity) {
            HomeworkDto dto = HomeworkDto.builder()
                    .homeworkId(hentity.getHomeworkId())
                    .memberId(hentity.getMemberId())
                    .lectureId(hentity.getLectureId())
                    .homeworkName(hentity.getHomeworkName())
                    .homeworkContent(hentity.getHomeworkContent())
                    .submitted(hentity.getSubmitted())
                    .deadline(hentity.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();
            list.add(dto);
        }
        return list;
    }

    //과제 선택 조회
    public HomeworkDto getHomework(Long id) {
        HomeworkEntity entity = homeworkRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return HomeworkDto.builder()
                .homeworkId(entity.getHomeworkId())
                .memberId(entity.getMemberId())
                .lectureId(entity.getLectureId())
                .homeworkName(entity.getHomeworkName())
                .homeworkContent(entity.getHomeworkContent())
                .submitted(entity.getSubmitted())
                .deadline(entity.getDeadline().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
    }

    // 선택한 과제 첨부파일 조회
    public HomeworkFileDto getFile(Long id) {
        HomeworkFileEntity entity = homeworkFileRepository.findbyHomeworkId(id);

        return HomeworkFileDto.builder()
                .homeworkId(entity.getHomeworkId())
                .fileName(entity.getFileName())
                .fileRename(entity.getFileRename())
                .build();

    }

    // 과제 생성
    public HomeworkEntity create(HomeworkDto homeworkDto) {
        HomeworkEntity entity = HomeworkEntity.builder()
                .homeworkId(homeworkDto.getHomeworkId())
                .memberId(homeworkDto.getMemberId())
                .lectureId(homeworkDto.getLectureId())
                .homeworkName(homeworkDto.getHomeworkName())
                .homeworkContent(homeworkDto.getHomeworkContent())
                .submitted(homeworkDto.getSubmitted())
                .deadline(LocalDateTime.parse(homeworkDto.getDeadline()))
                .build();
        return homeworkRepository.save(entity);
    }

    //과제 수정
    public HomeworkEntity update(HomeworkDto homeworkDto) {
        HomeworkEntity entity = homeworkRepository.findById(homeworkDto.getHomeworkId()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setHomeworkName(homeworkDto.getHomeworkName());
        entity.setHomeworkContent(homeworkDto.getHomeworkContent());
        entity.setDeadline(LocalDateTime.parse(homeworkDto.getDeadline()));
        return homeworkRepository.save(entity);

    }

    //과제 삭제
    public void delete(Long id) {
        HomeworkEntity entity = homeworkRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        homeworkRepository.delete(entity);
    }

    //과제 첨부파일 생성
    public HomeworkFileEntity createFile(HomeworkFileDto homeworkfileDto, Long id) {
        HomeworkFileEntity entity = HomeworkFileEntity.builder()
                .homeworkId(id)
                .fileName(homeworkfileDto.getFileName())
                .fileRename(homeworkfileDto.getFileRename())
                .build();
        return homeworkFileRepository.save(entity);
    }

    //과제 첨부파일 수정
    public HomeworkFileEntity updateFile(HomeworkFileDto homeworkfileDto, Long id) {
        HomeworkFileEntity entity = homeworkFileRepository.findbyHomeworkId(id);
entity.setFileName(homeworkfileDto.getFileName());
        entity.setFileRename(homeworkfileDto.getFileRename());
        return homeworkFileRepository.save(entity);
    }

    //과제 첨부파일 삭제
    public void deleteFile(Long id) {
        HomeworkFileEntity fileEntity = homeworkFileRepository.findbyHomeworkId(id);
        homeworkFileRepository.delete(fileEntity);
    }

}
