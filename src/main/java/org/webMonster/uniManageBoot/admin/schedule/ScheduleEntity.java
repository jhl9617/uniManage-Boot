package org.webMonster.uniManageBoot.admin.schedule;

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
@Table(name = "SCHEDULE")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHE_ID")
    private long sche_id;   //공지사항 번호
    @Column(name = "SCHE_TITLE")
    private String sche_title;   //공지사항 제목
    @Column(name = "SCHE_CONTENT")
    private String sche_content;   //공지사항 내용
    @Column(name = "START_DATE")
    private Date start_date;   //작성자
    @Column(name = "END_DATE")
    private Date end_date;   //등록일
    @Column(name = "READCOUNT")
    private int readcount;   //조회수
}
