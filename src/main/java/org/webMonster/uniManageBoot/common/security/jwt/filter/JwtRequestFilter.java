package org.webMonster.uniManageBoot.common.security.jwt.filter;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.webMonster.uniManageBoot.common.security.jwt.constants.SecurityConstants;
import org.webMonster.uniManageBoot.common.security.jwt.provider.JwtTokenProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

	private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    	String header = request.getHeader(SecurityConstants.TOKEN_HEADER);
        System.out.println("1");
        if (isEmpty(header) || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            System.out.println("2");
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("3");
        Authentication authentication = jwtTokenProvider.getAuthentication(header);


        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private boolean isEmpty(final CharSequence cs) {
    	return cs == null || cs.length() == 0;
    }

}
