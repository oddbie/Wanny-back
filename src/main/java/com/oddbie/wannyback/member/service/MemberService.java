package com.oddbie.wannyback.member.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.oddbie.wannyback.member.model.MemberResponseDto;
import com.oddbie.wannyback.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponseDto findMemberInfoById(Integer memberId) {
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
