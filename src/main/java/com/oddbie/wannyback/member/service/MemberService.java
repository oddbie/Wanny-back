package com.oddbie.wannyback.member.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oddbie.wannyback.member.model.MemberRequestDto;
import com.oddbie.wannyback.member.model.MemberResponseDto;
import com.oddbie.wannyback.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
// @Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewMember(MemberRequestDto memberRequestDto) {
        memberRepository.save(memberRequestDto.toMember(passwordEncoder));
    }

    public Boolean loginMember(MemberRequestDto memberRequestDto) {
        MemberResponseDto memberResponseDto = memberRepository.findByEmail(memberRequestDto.getEmail())
                .map(MemberResponseDto::of).orElseThrow(() -> new RuntimeException("No User Info"));
        if (passwordEncoder.matches(memberRequestDto.getPw(), memberResponseDto.getPw())) {
            log.info("match password!");
            return true;
        } else {
            return false;
        }
    }

    public MemberResponseDto findMemberInfoById(Long memberId) {
        return memberRepository.findById(memberId)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("No User Info"));
    }

    public MemberResponseDto findMemberInfoByEmail(String email) {
        return memberRepository.findByEmail(email)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("No User Info"));
    }
}
