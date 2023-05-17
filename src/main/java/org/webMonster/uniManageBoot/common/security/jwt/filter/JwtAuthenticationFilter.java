package org.webMonster.uniManageBoot.common.security.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.IOException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.webMonster.uniManageBoot.common.security.domain.CustomUser;
import org.webMonster.uniManageBoot.common.security.domain.UserCredentials;
import org.webMonster.uniManageBoot.common.security.jwt.constants.SecurityConstants;
import org.webMonster.uniManageBoot.common.security.jwt.provider.JwtTokenProvider;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        try {
            // Parse the JSON body of the request
            UserCredentials credentials = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);

            System.out.println("\nattemptAuthentication\n" + credentials.getUsername() + "," + credentials.getPassword());

            // Create an authentication token
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());

            // Authenticate the user
            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException | java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) {
        CustomUser user = ((CustomUser) authentication.getPrincipal());
    	long userNo = user.getUserNo();
    	String userId = user.getUserId();
    	
        List<String> roles = user.getAuthorities()
        	.stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());    	

        String token = jwtTokenProvider.createToken(userNo, userId, roles);

        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
        
        
    }
}
