package org.webMonster.uniManageBoot.student.department.entity;

import lombok.*;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.professor.lecture.entity.LectureEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "DEPARTMENT")   //테이블 자동 생성시키는 어노테이션임
@Entity
@Setter
@Getter
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private long departmentId;   //학과 번호(시퀀스)
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;   //학과명
    @Column(name = "CATEGORY")
    private String category;   //계열명

    @OneToMany(mappedBy = "department")
    private List<MemberEntity> members;

    @Builder.Default
    @OneToMany(mappedBy = "department")
    private List<LectureEntity> lectureEntities = new ArrayList<>();
}
