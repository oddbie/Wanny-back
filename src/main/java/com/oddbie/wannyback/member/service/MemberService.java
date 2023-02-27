package com.oddbie.wannyback.member.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.oddbie.wannyback.member.model.MemberRequestDto;
import com.oddbie.wannyback.member.model.MemberResponseDto;
import com.oddbie.wannyback.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// @Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public void registerNewMember(MemberRequestDto memberRequestDto) {

        memberRepository.save(memberRequestDto.toMember(null));
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
