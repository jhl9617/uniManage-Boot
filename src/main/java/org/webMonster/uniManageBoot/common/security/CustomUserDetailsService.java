package org.webMonster.uniManageBoot.common.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.webMonster.uniManageBoot.common.security.domain.CustomUser;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;
import org.webMonster.uniManageBoot.member.entity.MemberRepository;

@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("username : " + username);	// username : 1
		try {
			long memberId = Long.parseLong(username);
			log.info("memberId : " + memberId);
			MemberEntity member = repository.findByMemberId(memberId);

			log.info("memberrr : " + member);

			if (member == null) {
				throw new UsernameNotFoundException("User not found: " + username);
			}
			return new CustomUser(member);
		} catch (NumberFormatException e) {
			throw new UsernameNotFoundException("Invalid user ID format: " + username, e);
		}
	}
}
