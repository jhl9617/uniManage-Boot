package org.webMonster.uniManageBoot.admin.notice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeEntity;
import org.webMonster.uniManageBoot.admin.notice.model.dto.MessageDto;
import org.webMonster.uniManageBoot.admin.notice.model.dto.NoticeDto;
import org.webMonster.uniManageBoot.admin.notice.model.dto.SmsResponseDto;
import org.webMonster.uniManageBoot.admin.notice.model.service.NoticeService;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.member.entity.MemberRepository;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class NoticeController {
    private final NoticeService noticeService;

    private final MemberRepository memberRepository;


    @GetMapping("admin/notice/list")
    public Header<List<NoticeDto>> noticeList(
            @PageableDefault(sort = {"notice_id"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return noticeService.getNoticeList(pageable, searchCondition);
    }
    @GetMapping("admin/notice/{id}")
    public NoticeDto getNotice(@PathVariable Long id) {
        // 조회수 증가
        noticeService.increaseReadCount(id);
        //게시글 조회
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

    @GetMapping("/send")
    public String getSmsPage() {
        return "sendSms";
    }

    //공지사항 메세지 발송용
    @PostMapping("/sms/send")
    public SmsResponseDto sendSms(@RequestParam(name="notice_content")String content) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDto messageDto = new MessageDto();
        messageDto.setContent(content);
        List<MemberEntity> memberEntities = memberRepository.findAll().stream()
                .collect(Collectors.toMap(MemberEntity::getPhone, Function.identity(), (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());

        //        messageDto.setTo("");
        return noticeService.sendSms(messageDto);

//        for(MemberEntity entity : memberEntities){
//            messageDto.setTo(entity.getPhone());
//            noticeService.sendSms(messageDto);
//        }
//        return new SmsResponseDto();
    }


    //학생정보시스템 공지사항 리스트 조회용
    @GetMapping("student/notice")
    public Header<List<NoticeDto>> StudentNoticeList(
            @PageableDefault(sort = {"notice_id"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return noticeService.getNoticeList(pageable, searchCondition);
    }

    //학생정보시스템 공지사항 상세보기글 조회용
    @GetMapping("student/notice/{id}")
    public NoticeDto getStudentNotice(@PathVariable Long id) {
        // 조회수 증가
        noticeService.increaseReadCount(id);
        //게시글 조회
        return noticeService.getNotice(id);
    }



}