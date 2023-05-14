package org.webMonster.uniManageBoot.professor.lectureRoomFile.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_ROOM_FILE")
@Entity
public class LectureRoomFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_ROOM_ID")
    private long lectureRoomId;   //강의자료실 글번호
    @Column(name = "FILE_NAME")
    private String fileName;   //강의자료 파일명
    @Column(name = "FILE_RENAME")
    private String fileRename;   //변경된 강의자료 파일명
}
