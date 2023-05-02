package org.webMonster.uniManageBoot.member.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberLoginDto {
    private String member_id;
    private String name;
    private String member_pwd;
}