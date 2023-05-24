package org.webMonster.uniManageBoot.student.status.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "STATUS")  //테이블 자동 생성시키는 어노테이션임
@Entity
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_id_seq_gen")
    @SequenceGenerator(
            name = "status_id_seq_gen",
            sequenceName = "STATUS_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "STATUS_ID")
    private long statusId;   //학적변동 번호
    @Column(name = "MEMBER_ID")
    private long memberId;   //멤버 아이디
    @Column(name = "START_DATE")
    private Date startDate;   //휴학 시작일
    @Column(name = "END_DATE")
    private Date endDate;   //휴학 끝일
    @Column(name = "REASON_OF_LEAVE")
    private String reasonOfLeave;   //휴학사유
    @Column(name = "RETURN_DATE")
    private Date returnDate;   //복학일
    @Column(name = "APPLY_LEAVE_DATE")
    private Date applyLeaveDate;   //휴학접수날짜
    @Column(name = "APPLY_RETURN_DATE")
    private Date applyReturnDate;   //복학접수날짜
    @Column(name = "ALLOWED_LEAVE")
    private char allowedLeave;   //휴,복학 허용여부

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", insertable = false, updatable = false)
    private MemberEntity member;
}
