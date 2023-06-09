package org.webMonster.uniManageBoot.admin.scholarship.model.dto;

import lombok.*;
import org.webMonster.uniManageBoot.admin.scholarship.entity.ScholarshipEntity;

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


    public static ScholarshipDto fromEntity(ScholarshipEntity scholarshipEntity) {
        ScholarshipDto scholarshipDto = new ScholarshipDto();
        scholarshipDto.setSchoId(scholarshipEntity.getSchoId());
        scholarshipDto.setSchoTerm(scholarshipEntity.getSchoTerm());
        scholarshipDto.setSchoName(scholarshipEntity.getSchoName());
        scholarshipDto.setAmount(scholarshipEntity.getAmount());
        scholarshipDto.setMemberId(scholarshipEntity.getMemberId());
        return scholarshipDto;
    }

}
