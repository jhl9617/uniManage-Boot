package org.webMonster.uniManageBoot.professor.lecture.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 학생기능 - 학과별 강의시간표 조회용 검색키워드
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchValues {

    private String sv1;
    private String sv2;
    private String sv3;
    private Long sv4;

}
