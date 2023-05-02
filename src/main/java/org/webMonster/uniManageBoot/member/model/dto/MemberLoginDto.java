package org.webMonster.uniManageBoot.member.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class MemberLoginDto {
    private int member_id;
    private String member_pwd;
}