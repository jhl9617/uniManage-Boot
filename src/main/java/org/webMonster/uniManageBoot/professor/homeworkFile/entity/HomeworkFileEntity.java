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
    private long homeworkId;   //과제글 번호
    @Column(name = "FILE_NAME")
    private String fileName;   //과제파일명
    @Column(name = "FILE_RENAME")
    private String fileRename;   //변경된 과제파일명

}
