package org.webMonster.uniManageBoot.admin.notice.model.dto;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class SmsRequestDto {
    String type;
    String contentType;
    String countryCode;
    String from;
    String content;
    List<MessageDto> messages;

}