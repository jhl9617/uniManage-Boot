package org.webMonster.uniManageBoot.professor.lectureRoom.model.dto;

import lombok.*;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LectureRoomFileDto {

    private long lectureRoomId;   //강의자료실 글번호

    private String fileName;   //강의자료 파일명

    private String fileRename;   //변경된 강의자료 파일명
}
