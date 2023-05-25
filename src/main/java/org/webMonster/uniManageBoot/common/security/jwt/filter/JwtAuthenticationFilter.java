package org.webMonster.uniManageBoot.common.security.jwt.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.webMonster.uniManageBoot.common.security.domain.CustomUser;
import org.webMonster.uniManageBoot.common.security.domain.UserCredentials;
import org.webMonster.uniManageBoot.common.security.jwt.constants.SecurityConstants;
import org.webMonster.uniManageBoot.common.security.jwt.provider.JwtTokenProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    
    private final JwtTokenProvider jwtTokenProvider;






    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;

        this.jwtTokenProvider = jwtTokenProvider;



        setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UserCredentials credentials;
        try {

            credentials = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        System.out.println("authentication : " + authentication);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) throws ServletException, IOException {

        CustomUser user = ((CustomUser) authentication.getPrincipal());
        System.out.println(user + " 로그인 성공 ");

    	long userNo = user.getUserNo();
    	String userId = user.getUserId();
    	
        List<String> roles = user.getAuthorities()
        	.stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());
        System.out.println("roles : " + roles);
        String token = jwtTokenProvider.createToken(userNo, userId, roles);
        System.out.println("토큰 생성 성공 : " + token);

        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);



    }
}
