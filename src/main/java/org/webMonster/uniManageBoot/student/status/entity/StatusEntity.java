package org.webMonster.uniManageBoot.student.status.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "STATUS")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATUS_ID")
    private long status_id;   //학적변동 번호
    @Column(name = "MEMBER_ID")
    private long member_id;   //멤버 아이디
    @Column(name = "START_DATE")
    private Date start_date;   //휴학 시작일
    @Column(name = "END_DATE")
    private Date end_date;   //휴학 끝일
    @Column(name = "REASON_OF_LEAVE")
    private String reason_of_leave;   //휴학사유
    @Column(name = "RETURN_DATE")
    private Date return_date;   //복학일
    @Column(name = "APPLY_LEAVE_DATE")
    private Date apply_leave_date;   //휴학접수날짜
    @Column(name = "APPLY_RETURN_DATE")
    private Date apply_return_date;   //복학접수날짜 
    @Column(name = "ALLOWED_LEAVE")
    private char allowed_leave;   //휴,복학 허용여부
}
