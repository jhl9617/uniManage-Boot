package org.webMonster.uniManageBoot.admin.scholarship.model.dto;

import lombok.*;
import org.webMonster.uniManageBoot.admin.scholarship.entity.ScholarshipEntity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ScholarshipMemberDto {

    private long schoId;   //순번
    private long schoTerm;   //학기
    private String schoName;   //장학금명
    private int amount;   //장학금액
    private long memberId;   //학생번호

    private String name;  //학생명

//    public static ScholarshipDto fromEntity(ScholarshipEntity scholarshipEntity){
//        ScholarshipDto dto = new ScholarshipDto();
//
//        dto.setSchoId(scholarshipEntity.getSchoId());
//        dto.setSchoTerm(scholarshipEntity.getSchoTerm());
//        dto.setSchoName(scholarshipEntity.getSchoName());
//        dto.setAmount(scholarshipEntity.getAmount());
//        dto.setMemberId(scholarshipEntity.getMemberId());
//        dto.setName(scholarshipEntity.getMember().getName());
//        return dto;
//    }
}
