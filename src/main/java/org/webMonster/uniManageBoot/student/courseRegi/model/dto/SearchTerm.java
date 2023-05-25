package org.webMonster.uniManageBoot.student.courseRegi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 학생기능 -수강과목 시간표 검색용 값 설정
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchTerm {

    private Long sv1;
    private String sv2;
    private String sv3;

}
