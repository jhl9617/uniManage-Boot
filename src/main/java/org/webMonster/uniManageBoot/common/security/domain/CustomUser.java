package org.webMonster.uniManageBoot.common.security.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;

	private MemberEntity member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(MemberEntity member) {
		super(Long.toString(member.getMemberId()), member.getMemberPwd(), Collections.singletonList(new SimpleGrantedAuthority(String.valueOf(member.getAuth()))));

		this.member = member;
	}
	
	public CustomUser(MemberEntity member, Collection<? extends GrantedAuthority> authorities) {
		super(Long.toString(member.getMemberId()), member.getMemberPwd(), Collections.singletonList(new SimpleGrantedAuthority(String.valueOf(member.getAuth()))));
		
		this.member = member;
	}

	public long getUserNo() {
		return member.getMemberIdx();
	}
	
	public String getUserId() {
		return String.valueOf(member.getMemberId());
	}

	@Override
	public String toString() {
		return "CustomUser{" +
				"member=" + member +
				'}';
	}
}
