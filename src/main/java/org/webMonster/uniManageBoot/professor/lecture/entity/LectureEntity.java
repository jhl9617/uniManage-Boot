package org.webMonster.uniManageBoot.professor.lecture.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
public class LectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LECTURE_ID")
    private long lecture_id;  //강의번호
    @Column(name = "MEMBER_ID")
    private long member_id;  //아이디
    @Column(name = "CLASSIFICATION")
    private char classification;   //구분
    @Column(name = "SEMESTER")
    private long semester;   //학기
    @Column(name = "DEPARTMENT_ID")
    private long department_id;    //학과 번호
    @Column(name = "LECTURE_TITLE")
    private String lecture_title;   //강의명
    @Column(name = "NUMBER_OF_STUDENT")
    private int number_of_student;   //정원
    @Column(name = "CREDIT")
    private int credit;   //학점
    @Column(name = "ROOMCODE1")
    private String roomcode1;   //강의실코드1
    @Column(name = "ROOMCODE2")
    private String roomcode2;   //강의실코드2
    @Column(name = "ROOMCODE3")
    private String roomcode3;   //강의실코드3
    @Column(name = "TIMECODE1")
    private String timecode1;   //시간코드1
    @Column(name = "TIMECODE2")
    private String timecode2;   //시간코드2
    @Column(name = "TIMECODE3")
    private String timecode3;   //시간코드3
    @Column(name = "SYLLABUS_TITLE")
    private String syllabus_title;   //강의계획서명
    @Column(name = "SYLLABUS_RENAME")
    private String syllabus_rename;   //강의계획서_리네임
    @Column(name = "LECTURE_APPLY_STATUS")
    private char lecture_apply_status;   //강의 승인여부
}
