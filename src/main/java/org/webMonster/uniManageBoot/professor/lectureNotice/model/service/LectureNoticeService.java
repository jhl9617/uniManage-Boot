package org.webMonster.uniManageBoot.professor.lectureNotice.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeEntity;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.lectureNotice.entity.LectureNoticeEntity;
import org.webMonster.uniManageBoot.professor.lectureNotice.entity.LectureNoticeRepository;
import org.webMonster.uniManageBoot.professor.lectureNotice.entity.LectureNoticeRepositoryCustom;
import org.webMonster.uniManageBoot.professor.lectureNotice.model.dto.LectureNoticeDto;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class LectureNoticeService {
    @Autowired
    private LectureNoticeRepository lectureNoticeRepository;

    @Autowired
    private LectureNoticeRepositoryCustom lectureNoticeRepositoryCustom;

    // 강의별 공지사항 리스트 조회
    public Header<List<LectureNoticeDto>> getLectureNoticeList(Pageable pageable, SearchCondition searchCondition, Long id) {

        List<LectureNoticeDto> list = new ArrayList<>();

        Page<LectureNoticeEntity> lectureNoticeEntities = lectureNoticeRepositoryCustom.findAllBySearchCondition(pageable, searchCondition, id);

        for (LectureNoticeEntity entity : lectureNoticeEntities) {
            LectureNoticeDto dto = LectureNoticeDto.builder()
                    .lectureNoticeId(entity.getLectureNoticeId())
                    .lectureId(entity.getLectureId())
                    .lectureNoticeTitle(entity.getLectureNoticeTitle())
                    .lectureNoticeContent(entity.getLectureNoticeContent())
                    .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .readcount(entity.getReadcount())
                    .build();

            list.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) lectureNoticeEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(list, pagination);

    }

    //강의 공지사항 리스트 조회(페이징 x)
    public List<LectureNoticeDto> getLectureNoticeList(Long id){
        List<LectureNoticeDto> list = new ArrayList<>();
        List<LectureNoticeEntity> entity = lectureNoticeRepository.findByLectureId(id);
        for (LectureNoticeEntity lentity : entity) {
            LectureNoticeDto dto = LectureNoticeDto.builder()
                    .lectureNoticeId(lentity.getLectureNoticeId())
                    .lectureId(lentity.getLectureId())
                    .lectureNoticeTitle(lentity.getLectureNoticeTitle())
                    .lectureNoticeContent(lentity.getLectureNoticeContent())
                    .createdDate(lentity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .readcount(lentity.getReadcount())
                    .build();
            list.add(dto);
        }
        return list;

    }

    // 강의 공지사항 선택 조회
    public LectureNoticeDto getLectureNotice(Long id) {
        LectureNoticeEntity entity = lectureNoticeRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return LectureNoticeDto.builder()
                .lectureNoticeId(entity.getLectureNoticeId())
                .lectureId(entity.getLectureId())
                .lectureNoticeTitle(entity.getLectureNoticeTitle())
                .lectureNoticeContent(entity.getLectureNoticeContent())
                .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .readcount(entity.getReadcount())
                .build();
    }

    //게시글 조회시 조회수 1씩 증가
    @Transactional
    public void increaseReadCount(Long id) {
        LectureNoticeEntity entity = lectureNoticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        entity.setReadcount(entity.getReadcount() + 1); // 조회수 증가

        // 조회수 업데이트 저장
        lectureNoticeRepository.save(entity);
    }

    // 강의 공지 생성
    public LectureNoticeEntity create(LectureNoticeDto lectureNoticeDto) {
       LectureNoticeEntity entity = LectureNoticeEntity.builder()
               .lectureNoticeId(lectureNoticeDto.getLectureNoticeId())
               .lectureId(lectureNoticeDto.getLectureId())
               .lectureNoticeTitle(lectureNoticeDto.getLectureNoticeTitle())
               .lectureNoticeContent(lectureNoticeDto.getLectureNoticeContent())
               .createdDate(LocalDateTime.now())
               .readcount(lectureNoticeDto.getReadcount())
               .build();
        return lectureNoticeRepository.save(entity);
    }

    // 강의 공지 수정
    public LectureNoticeEntity update(LectureNoticeDto lectureNoticeDto) {
        LectureNoticeEntity entity = lectureNoticeRepository.findById(lectureNoticeDto.getLectureNoticeId()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setLectureNoticeTitle(lectureNoticeDto.getLectureNoticeTitle());
        entity.setLectureNoticeContent(lectureNoticeDto.getLectureNoticeContent());
        return lectureNoticeRepository.save(entity);
    }

    // 강의 공지 삭제
    public void delete(Long id) {
        LectureNoticeEntity entity = lectureNoticeRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        lectureNoticeRepository.delete(entity);
    }
}
