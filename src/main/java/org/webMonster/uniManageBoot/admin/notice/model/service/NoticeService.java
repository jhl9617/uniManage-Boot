package org.webMonster.uniManageBoot.admin.notice.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeEntity;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeRepository;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeRepositoryCustom;
import org.webMonster.uniManageBoot.admin.notice.model.dto.NoticeDto;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final NoticeRepositoryCustom noticeRepositoryCustom;
    
    public Header<List<NoticeDto>> getNoticeList(Pageable pageable, SearchCondition searchCondition) {
        List<NoticeDto> dtos = new ArrayList<>();

        Page<NoticeEntity> noticeEntities = NoticeRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (NoticeEntity entity : noticeEntities) {
            NoticeDto dto = NoticeDto.builder()
                    .notice_id(entity.getNotice_id())
                    .notice_title(entity.getNotice_title())
                    .notice_content(entity.getNotice_content())
                    .member_id(entity.getMember_id())
                    .created_date(entity.getCreated_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .build();
            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) noticeEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }
    /**
     * 게시글 가져오기
     */
    public NoticeDto getNotice(Long id) {
        NoticeEntity entity = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return NoticeDto.builder()
                .notice_id(entity.getNotice_id())
                .notice_title(entity.getNotice_title())
                .notice_content(entity.getNotice_content())
                .member_id(entity.getMember_id())
                .created_date(entity.getCreated_date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
    }
    /**
     * 게시글 등록
     */
    public NoticeEntity create(NoticeDto noticeDto) {
        NoticeEntity entity = NoticeEntity.builder()
                .notice_title(noticeDto.getNotice_title())
                .notice_content(noticeDto.getNotice_content())
                .member_id(noticeDto.getMember_id())
                .created_date(LocalDateTime.now())
                .build();
        return noticeRepository.save(entity);
    }
    /**
     * 게시글 수정
     */
    public NoticeEntity update(NoticeDto noticeDto) {
        NoticeEntity entity = noticeRepository.findById(noticeDto.getNotice_id()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setNotice_title(noticeDto.getNotice_title());
        entity.setNotice_content(noticeDto.getNotice_content());
        return noticeRepository.save(entity);
    }
    /**
     * 게시글 삭제
     */
    public void delete(Long id) {
        NoticeEntity entity = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        noticeRepository.delete(entity);
    }

}
