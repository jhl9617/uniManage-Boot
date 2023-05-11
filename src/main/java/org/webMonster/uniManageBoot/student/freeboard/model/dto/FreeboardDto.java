package org.webMonster.uniManageBoot.student.freeboard.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FreeboardDto {

    private long freeId;   //자유게시판 번호
    private String freeTitle;   //자유게시판 제목
    private String freeContent;   //자유게시판 내용
    private String createdDate;   //자유게시판 작성일
    private long memberId;   //자유게시판 작성자
    private String name; // 자유게시판 작성자 이름
}
