package org.webMonster.uniManageBoot.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "BOARD")  //Board 테이블 자동 생성시키는 어노테이션임
@Entity
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDX")
    private long idx;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENTS")
    private String contents;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
}