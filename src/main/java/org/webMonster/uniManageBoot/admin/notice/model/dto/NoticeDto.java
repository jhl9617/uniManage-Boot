package org.webMonster.uniManageBoot.admin.notice.model.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class NoticeDto {

    private long notice_id;
    private String notice_title;
    private String notice_content;
    private long member_id;
    private String created_date;
    private int readcount;

}
