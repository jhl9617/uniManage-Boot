package org.webMonster.uniManageBoot.admin.scholarship.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SCHOLARSHIP")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
public class ScholarshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHO_ID")
    private int scho_id;
    @Column(name = "SCHO_YEAR")
    private int scho_year;
    @Column(name = "SCHO_NAME")
    private String scho_name;
    @Column(name = "SCHO_AMOUNT")
    private int scho_amount;

}
