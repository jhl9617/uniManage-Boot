package org.webMonster.uniManageBoot.common.security.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserCredentials {
    private String username;
    private String password;

}