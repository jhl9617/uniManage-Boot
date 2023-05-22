package org.webMonster.uniManageBoot.admin.scholarship.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class ScholarshipDto {

    private long schoId;   //순번
    private long schoTerm;   //학기
    private String schoName;   //장학금명
    private int amount;   //장학금액
    private long memberId;   //학생번호

    private String name;
}
