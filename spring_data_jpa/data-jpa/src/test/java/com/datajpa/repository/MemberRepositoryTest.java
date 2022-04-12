package com.datajpa.repository;

import com.datajpa.dto.MemberDto;
import com.datajpa.entity.Member;
import com.datajpa.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  TeamRepository teamRepository;

  @Test
  public void testMember() {
    Member member = new Member("memberA");
    Member savedMember = memberRepository.save(member);

    Member findMember = memberRepository.findById(savedMember.getId()).get();

    assertEquals(findMember.getId(), member.getId());
    assertEquals(findMember.getUsername(), member.getUsername());
    assertEquals(findMember, member);
  }

  @Test
  public void basicCRUD() {
    Member member1 = new Member("member1");
    Member member2 = new Member("member2");
    memberRepository.save(member1);
    memberRepository.save(member2);

    // 단건 조회 검증
    Member findMember1 = memberRepository.findById(member1.getId()).get();
    Member findMember2 = memberRepository.findById(member2.getId()).get();
    assertEquals(member1, findMember1);
    assertEquals(member2, findMember2);

    // 목록 검증
    List<Member> all = memberRepository.findAll();
    assertEquals(all.size(), 2);

    // 건수 검증
    long count = memberRepository.count();
    assertEquals(count, 2);

    // 삭제 검증
    memberRepository.delete(member1);
    memberRepository.delete(member2);
    long deleteCount = memberRepository.count();
    assertEquals(deleteCount, 0);
  }

  @Test
  void findMemberDto() {

    Team team = new Team("teamA");
    teamRepository.save(team);

    Member member1 = new Member("member1", 10);
    member1.setTeam(team);
    memberRepository.save(member1);


    List<MemberDto> memberDto = memberRepository.findMemberDto();

    for (MemberDto dto : memberDto) {
      System.out.println("dto = " + dto);
    }


  }

  @Test
  void findEntityGraphByUsername() {
    Member member1 = new Member("member1");
    memberRepository.save(member1);
    List<Member> test = memberRepository.findEntityGraphByUsername("member1");
    System.out.println("test.get(0) = " + test.get(0));
  }
}