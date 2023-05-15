package org.webMonster.uniManageBoot.admin.notice.model.dto;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class MessageDto {
    String to;
    String content;
}
