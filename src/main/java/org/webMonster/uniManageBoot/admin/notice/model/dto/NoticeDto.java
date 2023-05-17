package org.webMonster.uniManageBoot.admin.notice.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class NoticeDto {

    private long noticeId;
    private String noticeTitle;
    private String noticeContent;
    private long memberId;
    private String createdDate;
    private int readcount;



}
