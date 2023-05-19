package org.webMonster.uniManageBoot.professor.homework.model.dto;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class HomeworkDto {

    private long homeworkId;   //과제글 번호

    private long memberId;   //학생 번호

    private long lectureId;   //강의 번호

    private String homeworkName;   //과제제목

    private String homeworkContent;   //과제 내용

    private String deadline;   //과제 제출기한

    private char submitted;   //과제 제출여부

}
