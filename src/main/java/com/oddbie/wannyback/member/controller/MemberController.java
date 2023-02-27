package com.oddbie.wannyback.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oddbie.wannyback.member.util.SecurityUtil;
import com.oddbie.wannyback.member.model.MemberRequestDto;
import com.oddbie.wannyback.member.model.MemberResponseDto;
import com.oddbie.wannyback.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberResponseDto> newMember(@RequestBody MemberRequestDto memberRequestDto) {
        log.info("receive register request {} {}", memberRequestDto.getEmail(), memberRequestDto.getPw());
        memberService.registerNewMember(memberRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> findMemberInfoById() {
        return ResponseEntity.ok(memberService.findMemberInfoById(SecurityUtil.getCurrentMemberId()));
    }

    @GetMapping("/{email}")
    public ResponseEntity<MemberResponseDto> findMemberInfoByEmail(@PathVariable String email) {
        return ResponseEntity.ok(memberService.findMemberInfoByEmail(email));
    }
}
