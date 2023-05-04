package org.webMonster.uniManageBoot.member.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MemberLoginDto {
    private long member_id;
    private String member_pwd;
}
