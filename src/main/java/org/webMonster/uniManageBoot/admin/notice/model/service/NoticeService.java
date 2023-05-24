package org.webMonster.uniManageBoot.admin.notice.model.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeEntity;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeRepository;
import org.webMonster.uniManageBoot.admin.notice.entity.NoticeRepositoryCustom;
import org.webMonster.uniManageBoot.admin.notice.model.dto.MessageDto;
import org.webMonster.uniManageBoot.admin.notice.model.dto.NoticeDto;
import org.webMonster.uniManageBoot.admin.notice.model.dto.SmsRequestDto;
import org.webMonster.uniManageBoot.admin.notice.model.dto.SmsResponseDto;
import org.webMonster.uniManageBoot.common.Header;
import org.webMonster.uniManageBoot.common.Pagination;
import org.webMonster.uniManageBoot.common.SearchCondition;
import org.webMonster.uniManageBoot.professor.homework.entity.HomeworkEntity;
import org.webMonster.uniManageBoot.professor.homework.model.dto.HomeworkDto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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

    @Autowired
    private JavaMailSender mailSender;



    //sms api
    @Value("${naver-cloud-sms.accessKey}")
    private String accessKey;

    @Value("${naver-cloud-sms.secretKey}")
    private String secretKey;

    @Value("${naver-cloud-sms.serviceId}")
    private String serviceId;

    @Value("${naver-cloud-sms.senderPhone}")
    private String phone;
    
    public Header<List<NoticeDto>> getNoticeList(Pageable pageable, SearchCondition searchCondition) {
        List<NoticeDto> dtos = new ArrayList<>();

        Page<NoticeEntity> noticeEntities = noticeRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (NoticeEntity entity : noticeEntities) {
            NoticeDto dto = NoticeDto.builder()
                    .noticeId(entity.getNoticeId())
                    .noticeTitle(entity.getNoticeTitle())
                    .noticeContent(entity.getNoticeContent())
                    .memberId(entity.getMemberId())
                    .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 hh:mm:ss")))
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
                .noticeId(entity.getNoticeId())
                .noticeTitle(entity.getNoticeTitle())
                .noticeContent(entity.getNoticeContent())
                .memberId(entity.getMemberId())
                .readcount(entity.getReadcount())
                .createdDate(entity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 hh:mm:ss")))
                .build();
    }

    //게시글 조회시 조회수 1씩 증가
    @Transactional
    public void increaseReadCount(Long id) {
        NoticeEntity entity = noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        entity.setReadcount(entity.getReadcount() + 1); // 조회수 증가

        // 조회수 업데이트 저장
        noticeRepository.save(entity);
    }
    /**
     * 게시글 등록
     */
    public NoticeEntity create(NoticeDto noticeDto) {
        NoticeEntity entity = NoticeEntity.builder()
                .noticeId(noticeDto.getNoticeId())
                .noticeTitle(noticeDto.getNoticeTitle())
                .noticeContent(noticeDto.getNoticeContent())
                .memberId(noticeDto.getMemberId())
                .createdDate(LocalDateTime.now())
                .build();
        return noticeRepository.save(entity);
    }
    /**
     * 게시글 수정
     */
    public NoticeEntity update(NoticeDto noticeDto) {
        NoticeEntity entity = noticeRepository.findById(noticeDto.getNoticeId()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setNoticeTitle(noticeDto.getNoticeTitle());
        entity.setNoticeContent(noticeDto.getNoticeContent());
        return noticeRepository.save(entity);
    }
    /**
     * 게시글 삭제
     */
    public void delete(Long id) {
        NoticeEntity entity = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        noticeRepository.delete(entity);
    }

//    sms api
    public String makeSignature(Long time) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String space = " ";
        String newLine = "\n";
        String method = "POST";
        String url = "/sms/v2/services/"+ this.serviceId+"/messages";
        String timestamp = time.toString();
        String accessKey = this.accessKey;
        String secretKey = this.secretKey;

        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();

        SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);

        byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
        String encodeBase64String = Base64.encodeBase64String(rawHmac);

        return encodeBase64String;
    }

    //sms 발송 요청
    public SmsResponseDto sendSms(MessageDto messageDto) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        Long time = System.currentTimeMillis();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-ncp-apigw-timestamp", time.toString());
        headers.set("x-ncp-iam-access-key", accessKey);
        headers.set("x-ncp-apigw-signature-v2", makeSignature(time));

        List<MessageDto> messages = new ArrayList<>();
        messages.add(messageDto);

        SmsRequestDto request = SmsRequestDto.builder()
                .type("SMS")
                .contentType("COMM")
                .countryCode("82")
                .from(phone)
                .content(messageDto.getContent())
                .messages(messages)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(request);
        HttpEntity<String> httpBody = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        SmsResponseDto response = restTemplate.postForObject(new URI("https://sens.apigw.ntruss.com/sms/v2/services/"+ serviceId +"/messages"), httpBody, SmsResponseDto.class);

        return response;
    }


    //email 보내기
    public void sendEmail(String content) {

        String setFrom = "itsyksj@naver.com";
        String toMail = "jhl9617@gmail.com";
        String title = "cookology에서 보내는 인증이메일 입니다.";

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //학생정보시스템 메인페이지 공지사항 리스트 4개 조회용
    public List<NoticeDto> getNoticeList(){
        List<NoticeDto> list = new ArrayList<>();
        List<NoticeEntity> entity = noticeRepository.findAll();
        for (NoticeEntity nentity : entity) {
            NoticeDto dto = NoticeDto.builder()
                    .noticeId(nentity.getNoticeId())
                    .noticeTitle(nentity.getNoticeTitle())
                    .noticeContent(nentity.getNoticeContent())
                    .memberId(nentity.getMemberId())
                    .createdDate(nentity.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .readcount(nentity.getReadcount())
                    .build();
            list.add(dto);
        }
        return list;
    }


}
