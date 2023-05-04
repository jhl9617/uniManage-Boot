package org.webMonster.uniManageBoot.student.department.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "DEPARTMENT")   //테이블 자동 생성시키는 어노테이션임
@Entity
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private long department_id;   //학과 번호(시퀀스)
    @Column(name = "DEPARTMENT_NAME")
    private String department_name;   //학과명
    @Column(name = "CATEGORY")
    private String category;   //계열명
}
