package com.oddbie.wannyback.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oddbie.wannyback.member.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);
}
