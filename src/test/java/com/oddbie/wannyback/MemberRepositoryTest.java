package com.oddbie.wannyback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.oddbie.wannyback.member.model.Member;
import com.oddbie.wannyback.member.model.UserRole;
import com.oddbie.wannyback.member.repository.MemberRepository;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository repository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        // Member member = new Member(null, "id", "pw", "name", "num",
        // UserRole.ROLE_USER);
        // repository.save(member);

        // Member findMember = repository.findByEmail(member.getEmail());
        // assertEquals(findMember.getSeq(), member.getSeq());
        // assertEquals(findMember.getName(), member.getName());
        // assertEquals(findMember.getPhone(), member.getPhone());
        // assertEquals(findMember.getRole(), member.getRole());
        // assertEquals(findMember, member);
    }
}
