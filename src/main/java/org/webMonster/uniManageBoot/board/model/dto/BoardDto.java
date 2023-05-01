package org.webMonster.uniManageBoot.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {

    private long idx;
    private String title;
    private String contents;
    private String author;
    private String createdAt;

}
