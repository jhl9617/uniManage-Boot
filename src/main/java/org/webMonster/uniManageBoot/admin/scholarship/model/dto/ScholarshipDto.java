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

    private long schoId;
    private long schoTerm;
    private String schoName;
    private int amount;
    private long memberId;

}
