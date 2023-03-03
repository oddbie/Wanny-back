package com.oddbie.wannyback.member.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private String email;
    private String pw;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getEmail(), member.getPw());
    }
}
