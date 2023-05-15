package org.webMonster.uniManageBoot.admin.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeEntity;
import org.webMonster.uniManageBoot.admin.notice.model.dto.NoticeDto;
import org.webMonster.uniManageBoot.admin.notice.model.service.NoticeService;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class NoticeController {
    public final NoticeService noticeService;

    @GetMapping("admin/notice/list")
    public Header<List<NoticeDto>> noticeList(
            @PageableDefault(sort = {"notice_id"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return noticeService.getNoticeList(pageable, searchCondition);
    }
    @GetMapping("admin/notice/{id}")
    public NoticeDto getNotice(@PathVariable Long id) {
        return noticeService.getNotice(id);
    }
    @PostMapping("admin/notice")
    public NoticeEntity create(@RequestBody NoticeDto noticeDto) {
        return noticeService.create(noticeDto);
    }
    @PatchMapping("admin/notice")
    public NoticeEntity update(@RequestBody NoticeDto noticeDto) {
        return noticeService.update(noticeDto);
    }
    @DeleteMapping("admin/notice/{id}")
    public void delete(@PathVariable Long id) {
        noticeService.delete(id);
    }


}
