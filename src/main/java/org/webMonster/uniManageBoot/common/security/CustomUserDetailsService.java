package org.webMonster.uniManageBoot.common.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.webMonster.uniManageBoot.common.security.domain.CustomUser;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.member.entity.MemberRepository;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository repository;

	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		log.info("userName : " + memberId);

		MemberEntity member = repository.findByMemberId(Long.parseLong(memberId)).get(0);

		log.info("member : " + member);

		return member == null ? null : new CustomUser(member);
	}

}
