package org.webMonster.uniManageBoot.common.security.domain;


import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;

import java.util.Collection;
import java.util.stream.Collectors;


public class CustomUser extends User {

	private static final long serialVersionUID = 1L;

	private MemberEntity member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(MemberEntity member) {

		super(Long.toString(member.getMemberId()), member.getMemberPwd(), member.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(Integer.toString(member.getAuth()))).collect(Collectors.toList()));

		this.member = member;
	}
	
	public CustomUser(MemberEntity member, Collection<? extends GrantedAuthority> authorities) {
		super(String.valueOf(member.getMemberId()), member.getMemberPwd(), authorities);
		
		this.member = member;
	}

	public long getUserNo() {
		return member.getMemberIdx();
	}
	
	public String getUserId() {
		return Long.toString(member.getMemberId());
	}
	
}
