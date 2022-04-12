package com.datajpa.repository;

import com.datajpa.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberJpaRepositoryTest {


  @Autowired
  MemberJpaRepository memberJpaRepository;


  @Test
  public void testMember() {
    Member member = new Member("memberA");
    Member saveMember = memberJpaRepository.save(member);
    Member findMember = memberJpaRepository.find(saveMember.getId());

    assertEquals(findMember.getId(), member.getId());
    assertEquals(findMember.getUsername(), member.getUsername());
    assertEquals(findMember, member);
  }

  @Test
  public void basicCRUD() {
    Member member1 = new Member("member1");
    Member member2 = new Member("member2");
    memberJpaRepository.save(member1);
    memberJpaRepository.save(member2);

    // 단건 조회 검증
    Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
    Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
    assertEquals(member1, findMember1);
    assertEquals(member2, findMember2);

    // 목록 검증
    List<Member> all = memberJpaRepository.findAll();
    assertEquals(all.size(), 2);

    // 건수 검증
    long count = memberJpaRepository.count();
    assertEquals(count, 2);

    // 삭제 검증
    memberJpaRepository.delete(member1);
    memberJpaRepository.delete(member2);
    long deleteCount = memberJpaRepository.count();
    assertEquals(deleteCount, 0);
  }

  @Test
  void findByUsername() {
    Member m1 = new Member("AAA", 10);
    Member m2 = new Member("BBB", 20);
    memberJpaRepository.save(m1);
    memberJpaRepository.save(m2);

    List<Member> result = memberJpaRepository.findByUsername("AAA");

    Member findMember = result.get(0);

    assertThat(findMember).isEqualTo(m1);
  }
}