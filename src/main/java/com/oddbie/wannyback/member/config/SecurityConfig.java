package com.oddbie.wannyback.member.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.oddbie.wannyback.member.jwt.TokenProvider;
import com.oddbie.wannyback.member.jwt.JwtAuthenticationEntryPoint;
import com.oddbie.wannyback.member.jwt.JwtAccessDeniedHandler;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public WebSecurityCustomizer webSecurityCustomizer() {
    // return (web) -> web.ignoring().antMatchers("/favicon.ico");
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(jwtAccessDeniedHandler);

        http.sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // http.authorizeHttpRequests()
        // .antMatchers("/favicon.ico").permitAll()
        // .anyRequest().authenticated();
        http
                        // .antMatchers("/", "/api/hello").permitAll()
                        .antMatcher("/api/secure/**")
                        .authorizeRequests()
                        .antMatchers("/favicon.ico").permitAll()
                        .antMatchers("/auth/**").permitAll()
                        .antMatchers("/api/**").permitAll()
                        .anyRequest().authenticated();

        http
                .apply(new JwtSecurityConfig(tokenProvider));

        return http.build();
    }
}
