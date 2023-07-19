package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.util.Assert;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    private MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void clearStore() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);
        Member findMember = memberRepository.findById(member.getId()).get();
        Assertions.assertEquals(findMember, member);
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("spring");
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setName("spring");
        memberRepository.save(member2);

        Member findMember1 = memberRepository.findByName(member.getName()).get();
        assertThat(member).isEqualTo(findMember1);

        Member findMember2 = memberRepository.findByName(member.getName()).get();
        assertThat(member).isEqualTo(findMember2);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("spring");
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setName("spring");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}