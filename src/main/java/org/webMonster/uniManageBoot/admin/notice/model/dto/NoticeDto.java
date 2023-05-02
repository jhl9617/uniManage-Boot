package org.webMonster.uniManageBoot.admin.notice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeDto {

    private long notice_id;
    private String notice_title;
    private String notice_content;
    private int member_id;
    private String created_date;
    private int readcount;

}
