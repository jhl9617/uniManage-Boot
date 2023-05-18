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
    private char cancelledApply;  //휴강 승인여부
}
