package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_ROOM_FILE")
@Entity
@Getter
@Setter
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
