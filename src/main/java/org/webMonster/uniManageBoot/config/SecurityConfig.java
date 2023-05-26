package org.webMonster.uniManageBoot.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.webMonster.uniManageBoot.common.security.CustomAccessDeniedHandler;
import org.webMonster.uniManageBoot.common.security.CustomLoginSuccessHandler;
import org.webMonster.uniManageBoot.common.security.CustomUserDetailsService;
import org.webMonster.uniManageBoot.common.security.jwt.filter.JwtAuthenticationFilter;
import org.webMonster.uniManageBoot.common.security.jwt.filter.JwtRequestFilter;
import org.webMonster.uniManageBoot.common.security.jwt.provider.JwtTokenProvider;

import javax.sql.DataSource;
import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;


    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("security config ...");

        /*http.authorizeRequests()
                .antMatchers("/board/register")
                .hasRole("MEMBER");  //로그인한 회원만 접근가능
        //비로그인시 자동 로그인 화면으로 넘어감

        http.authorizeRequests()
                .antMatchers("/notice/list")
                .permitAll();

        http.authorizeRequests()
                .antMatchers("/notice/register")
                .hasRole("ADMIN");  //관리자만 접근가능
        //비로그인시 자동 로그인 화면으로 넘어감*/

        // 폼 기반 인증 기능을 사용한다.
        http.formLogin().disable()
                .httpBasic().disable();

        http.addFilterAt(new JwtAuthenticationFilter(authenticationManager(), jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtRequestFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);



        // 접근 거부 처리자의 URI를 지정
        http.exceptionHandling()
                .accessDeniedPage("/accessError");

        http.cors();

        http.csrf().disable();

        // 사용자가 정의한 로그인 페이지의 URI를 지정한다.

        // 접근 거부 처리자의 URI를 지정
        http.exceptionHandling()
                .accessDeniedPage("/accessError");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
        auth.inMemoryAuthentication()
                .withUser("1234")     //아이디
                .password("{noop}1234")  //패스워드
                .roles("MEMBER");

        auth.inMemoryAuthentication()
                .withUser("2345")      //아이디
                .password("{noop}1234") //패스워드
                .roles("ADMIN");

        auth.userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder());

    }


    // CustomAccessDeniedHandler를 빈으로 등록한다.
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    // CustomLoginSuccessHandler를 빈으로 등록한다.
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomLoginSuccessHandler();
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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public UserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }


}