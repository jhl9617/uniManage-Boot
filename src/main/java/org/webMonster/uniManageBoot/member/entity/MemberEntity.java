package org.webMonster.uniManageBoot.member.entity;


import lombok.*;
import org.webMonster.uniManageBoot.admin.scholarship.entity.ScholarshipEntity;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;
import org.webMonster.uniManageBoot.student.department.entity.DepartmentEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MEMBER")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
@Getter
@Setter
public class MemberEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_IDX")
    private long memberIdx;             //시퀀스
    @Column(name = "MEMBER_ID")
    private long memberId;  //아이디
    @Column(name = "MEMBER_PWD")
    private String memberPwd;  //비밀번호
    @Column(name = "NAME")
    private String name;        //이름
    @Column(name = "DEPARTMENT_ID")
    private int departmentId;  //학과 번호
    @Column(name = "GRADE")
    private int grade;        //학년
    @Column(name = "BIRTHDAY")
    private Date birthday;      //생년월일
    @Column(name = "PHONE")
    private String phone;       //전화번호
    @Column(name = "EMAIL")
    private String email;       //이메일
    @Column(name = "POSTCODE")
    private int postcode;       //우편번호
    @Column(name = "ADDRESS1")
    private String address1;   //주소1
    @Column(name = "ADDRESS2")
    private String address2;    //주소2
    @Column(name = "AUTH")
    private int auth;           //권한구분:교수 1, 교직원 2,재학생 3, 졸업생 4, 휴학생 5

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", insertable = false, updatable = false)
    private DepartmentEntity department;

    @Builder.Default
    @OneToMany(mappedBy = "member")
    private List<ScholarshipEntity> scholarshipEntities = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member")
    private List<LectureEntity> lectureEntities = new ArrayList<>();
}
