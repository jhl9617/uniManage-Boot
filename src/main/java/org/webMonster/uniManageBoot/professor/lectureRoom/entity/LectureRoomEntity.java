package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_ROOM")
@Entity
public class LectureRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_ROOM_ID")
    private long lecture_room_id;   //강의자료실 글번호
    @Column(name = "LECTURE_ID")
    private long lecture_id;   //강의번호
    @Column(name = "MEMBER_ID")
    private long member_id;   //아이디
    @Column(name = "LECTURE_ROOM_TITLE")
    private String lecture_room_title;   //강의자료 제목
    @Column(name = "LECTURE_ROOM_CONTENT")
    private String lecture_room_content;   //강의자료 내용 
    @Column(name = "CREATED_DATE")
    private LocalDateTime created_date;   //강의자료 작성일
    @Column(name = "READCOUNT")
    private int readcount;   //조회수
}
