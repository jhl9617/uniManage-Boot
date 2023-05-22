package org.webMonster.uniManageBoot.student.freeboard.model.dto;

import lombok.*;
import org.webMonster.uniManageBoot.student.freeboard.entity.FreeboardEntity;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FreeboardDto {

    private long freeId;   //자유게시판 번호
    private String freeTitle;   //자유게시판 제목
    private String freeContent;   //자유게시판 내용
    private String createdDate;   //자유게시판 작성일
    private long memberId;   //자유게시판 작성자

    private String name; // 자유게시판 작성자 이름

    public static FreeboardDto modifyFreeboard(FreeboardEntity entity){
        FreeboardDto dto = new FreeboardDto();
        dto.setFreeTitle(dto.getFreeTitle());
        dto.setFreeContent(dto.getFreeContent());

        return dto;
    }
}