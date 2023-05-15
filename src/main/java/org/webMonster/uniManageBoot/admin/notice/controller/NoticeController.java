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

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class NoticeController {
    private final NoticeService noticeService;



    @GetMapping("/notice/list")
    public Header<List<NoticeDto>> noticeList(
            @PageableDefault(sort = {"idx"}) Pageable pageable,
            SearchCondition searchCondition
    ) {
        return noticeService.getNoticeList(pageable, searchCondition);
    }
    @GetMapping("/notice/{id}")
    public NoticeDto getNotice(@PathVariable Long id) {
        return noticeService.getNotice(id);
    }
    @PostMapping("/notice")
    public NoticeEntity create(@RequestBody NoticeDto noticeDto) {
        return noticeService.create(noticeDto);
    }
    @PatchMapping("/notice")
    public NoticeEntity update(@RequestBody NoticeDto noticeDto) {
        return noticeService.update(noticeDto);
    }
    @DeleteMapping("/notice/{id}")
    public void delete(@PathVariable Long id) {
        noticeService.delete(id);
    }
    @GetMapping("/send")
    public String getSmsPage() {
        return "sendSms";
    }

    @PostMapping("/sms/send")
    public String sendSms(@RequestBody MessageDto messageDto, Model model) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println("messageDto = " + messageDto);
        /*SmsResponseDto response = noticeService.sendSms(messageDto);*/

        noticeService.sendEmail(messageDto.getContent());

/*        model.addAttribute("response", response);*/
        return "result";
    }
}