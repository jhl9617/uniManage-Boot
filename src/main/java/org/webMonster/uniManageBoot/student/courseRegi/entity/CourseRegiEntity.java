package org.webMonster.uniManageBoot.student.courseRegi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "COURSE_REGI")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class CourseRegiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_regi_seq_gen")
    @SequenceGenerator(
            name = "course_regi_seq_gen",
            sequenceName = "COURSE_REGI_ID_SEQ",
            allocationSize=1
    )
    @Column(name = "COURSE_REGI_ID")
    private long courseRegiId;   //수강신청 번호
    @Column(name = "MEMBER_ID")
    private long memberId;   //멤버 번호
    @Column(name = "LECTURE_ID")
    private long lectureId;   //강의 아이디
    @Column(name = "COURSE_REGI_TERM")
    private long courseRegiTerm;   //신청학기


    @ManyToOne
    @JoinColumn(name = "LECTURE_ID", referencedColumnName = "LECTURE_ID", insertable = false, updatable = false)
    private LectureEntity lecture;


}

