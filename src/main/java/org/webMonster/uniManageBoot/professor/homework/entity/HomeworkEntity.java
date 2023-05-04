package org.webMonster.uniManageBoot.professor.homework.entity;

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
@Table(name = "HOMEWORK")
@Entity
public class HomeworkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOMEWORK_ID")
    private long homework_id;   //과제글 번호
    @Column(name = "MEMBER_ID")
    private long member_id;   //학생 번호
    @Column(name = "LECTURE_ID")
    private long lecture_id;   //강의 번호
    @Column(name = "HOMEWORK_NAME")
    private String homework_name;   //과제제목
    @Column(name = "HOMEWORK_CONTENT")
    private String homework_content;   //과제 내용
    @Column(name = "DEADLINE")
    private Date deadline;   //과제 제출기한
    @Column(name = "SUBMITTED")
    private char submitted;   //과제 제출여부
}
