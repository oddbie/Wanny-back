package com.oddbie.wannyback.member.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class MemberRequestDto {
    private String email;
    private String pw;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder().email(email).pw(passwordEncoder.encode(pw)).role(UserRole.ROLE_USER).build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, pw);
    }
}
