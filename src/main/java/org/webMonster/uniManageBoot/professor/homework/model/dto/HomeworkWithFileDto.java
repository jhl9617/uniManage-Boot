package org.webMonster.uniManageBoot.professor.homework.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class HomeworkWithFileDto {
    private HomeworkDto homework;
    private HomeworkFileDto homeworkFile;
}
