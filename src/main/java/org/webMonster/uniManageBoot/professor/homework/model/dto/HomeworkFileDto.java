package org.webMonster.uniManageBoot.professor.homework.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class HomeworkFileDto {

    private long homeworkId;   //과제글 번호

    private String fileName;   //과제파일명

    private String fileRename;   //변경된 과제파일명
}
