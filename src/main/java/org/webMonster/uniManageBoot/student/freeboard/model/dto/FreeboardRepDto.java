package org.webMonster.uniManageBoot.student.freeboard.model.dto;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FreeboardRepDto {
    private long freeRepId;   //자유게시판 댓글 번호
    private long freeId;   //자유게시판 번호
    private String freeRepContent;   //댓글 내용
    private String createdDate;   //댓글 작성일
    private long memberId;   //댓글 작성자

    private String name; // 댓글 작성자 이름

}
