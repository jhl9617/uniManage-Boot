package org.webMonster.uniManageBoot.professor.homeworkFile.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "HOMEWORK_FILE")
@Entity
public class HomeworkFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOMEWORK_ID")
    private long homework_id;   //과제글 번호
    @Column(name = "FILE_NAME")
    private String file_name;   //과제파일명
    @Column(name = "FILE_RENAME")
    private String file_rename;   //변경된 과제파일명

}
