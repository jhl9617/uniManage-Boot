package org.webMonster.uniManageBoot.admin.schedule.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SCHEDULE")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
@Setter
@Getter
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sche_seq_gen")
    @SequenceGenerator(
            name = "sche_seq_gen",
            sequenceName = "SCHE_ID_SEQ",
            allocationSize=1
    )
    @Column(name = "SCHE_ID")
    private long scheId;   //순번
    @Column(name = "SCHE_TITLE")
    private String scheTitle;   //제목
    @Column(name = "SCHE_CONTENT")
    private String scheContent;   //내용
    @Column(name = "START_DATE")
    private Date startDate;   //시작일
    @Column(name = "END_DATE")
    private Date endDate;   //끝일
}
