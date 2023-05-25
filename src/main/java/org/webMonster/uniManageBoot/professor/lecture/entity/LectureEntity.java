package org.webMonster.uniManageBoot.professor.lecture.entity;


import lombok.*;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.professor.lectureClass.entity.LectureClassEntity;
import org.webMonster.uniManageBoot.professor.lectureClassTime.entity.LectureClassTimeEntity;
import org.webMonster.uniManageBoot.student.department.entity.DepartmentEntity;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "LECTURE")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
@Getter
@Setter
public class LectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecture_id_seq_gen")
    @SequenceGenerator(
            name = "lecture_id_seq_gen",
            sequenceName = "LECTURE_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "LECTURE_ID")
    private long lectureId;  //강의번호
    @Column(name = "MEMBER_ID")
    private long memberId;  //아이디
    @Column(name = "CLASSIFICATION")
    private char classification;   //구분
    @Column(name = "SEMESTER")
    private long semester;   //학기
    @Column(name = "DEPARTMENT_ID")
    private long departmentId;    //학과 번호
    @Column(name = "LECTURE_TITLE")
    private String lectureTitle;   //강의명
    @Column(name = "NUMBER_OF_STUDENT")
    private int numberOfStudent;   //정원
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
    private String syllabusTitle;   //강의계획서명
    @Column(name = "SYLLABUS_RENAME")
    private String syllabusRename;   //강의계획서_리네임
    @Column(name = "LECTURE_APPLY_STATUS")
    private char lectureApplyStatus;   //강의 승인여부

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", insertable = false, updatable = false)
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID", insertable = false, updatable = false)
    private DepartmentEntity department;

//    @ManyToOne
//    @JoinColumn(name = "LECTURE_CLASS_IDX", referencedColumnName = "LECTURE_CLASS_IDX", insertable = false, updatable = false)
//    private LectureClassEntity lectureClass;

}
