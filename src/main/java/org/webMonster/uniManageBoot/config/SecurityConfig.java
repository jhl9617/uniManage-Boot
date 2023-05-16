package org.webMonster.uniManageBoot.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.webMonster.uniManageBoot.common.security.CustomAccessDeniedHandler;
import org.webMonster.uniManageBoot.common.security.CustomUserDetailsService;
import org.webMonster.uniManageBoot.common.security.RestAuthenticationEntryPoint;
import org.webMonster.uniManageBoot.common.security.jwt.filter.JwtAuthenticationFilter;
import org.webMonster.uniManageBoot.common.security.jwt.filter.JwtRequestFilter;
import org.webMonster.uniManageBoot.common.security.jwt.provider.JwtTokenProvider;

import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final JwtTokenProvider jwtTokenProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config ...");
		
		http.formLogin();
		
		http.cors();
		
		http.csrf().disable();
		
		http.addFilterAt(new JwtAuthenticationFilter(authenticationManager(), jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new JwtRequestFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeRequests()
		.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		/*.antMatchers("/codes/**").access("permitAll")
		.antMatchers("/s/**").access("permitAll")
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.antMatchers("/codedetails/**").access("hasRole('ADMIN')")
		.antMatchers("/boards/**").access("request.method == 'GET' ? permitAll : hasAnyRole('MEMBER', 'ADMIN')")
		.antMatchers("/notices/**").access("request.method == 'GET' ? permitAll : hasRole('ADMIN')")
		.antMatchers("/items/**").access("request.method == 'GET' ? permitAll : hasRole('ADMIN')")
		.antMatchers("/coins/**").access("hasRole('MEMBER')")
		.antMatchers("/useritems/**").access("hasAnyRole('MEMBER', 'ADMIN')")
		.antMatchers("/pds/**").access("request.method == 'GET' ? permitAll : hasRole('ADMIN')")*/
		.anyRequest().authenticated();
		
		http.exceptionHandling()
		.authenticationEntryPoint(new RestAuthenticationEntryPoint())
		.accessDeniedHandler(accessDeniedHandler());
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService())
		.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    
	    CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.setExposedHeaders(Arrays.asList("Authorization","Content-Disposition"));
        
	    source.registerCorsConfiguration("/**", config);
	    
	    return source;
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
}
