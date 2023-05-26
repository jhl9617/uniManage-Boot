package org.webMonster.uniManageBoot.professor.cancelledLecture.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ApplyDto {
    private long cancelledLectureIdx;   //휴강게시글 시퀀스
    private long memberId;              //아이디(작성자)
    private char cancelledApply;        //휴강 승인여부
}
