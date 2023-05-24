package org.webMonster.uniManageBoot.professor.lectureRoom.entity;

import lombok.*;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.professor.lectureRoomTimetable.entity.LectureRoomTimetableEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE_ROOM")
@Entity
@Getter
@Setter
public class LectureRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_ROOM_ID")
    private long lectureRoomId;   //강의자료실 글번호
    @Column(name = "LECTURE_ID")
    private long lectureId;   //강의번호
    @Column(name = "MEMBER_ID")
    private long memberId;   //아이디
    @Column(name = "LECTURE_ROOM_TITLE")
    private String lectureRoomTitle;   //강의자료 제목
    @Column(name = "LECTURE_ROOM_CONTENT")
    private String lectureRoomContent;   //강의자료 내용
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;   //강의자료 작성일
    @Column(name = "READCOUNT")
    private int readcount;   //조회수

    // 다른 엔티티와의 관계 설정
//    @OneToMany(mappedBy = "lectureClass")
//    private List<LectureRoomTimetableEntity> lectureRoomTimetables;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", insertable = false, updatable = false)
    private MemberEntity member;
}
