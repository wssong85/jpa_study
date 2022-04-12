package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
//      1: 1차캐시 입력
//      Member member = new Member();
//      member.setId(1L);
//      member.setName("HelloA");
//      em.persist(member);

//      2: 1차캐시 조회
//      Member findMember = em.find(Member.class, 1L);
//      System.out.println("findMember.getId() = " + findMember.getId());
//      System.out.println("findMember.getName() = " + findMember.getName());

//      3: 1차캐시 수정 -> flush and commit 디비 수정
//      Member findMember = em.find(Member.class, 1L);
//      findMember.setName("HelloJPA");

      // 4: JPQL
//      List<Member> result = em.createQuery("select m from Member m", Member.class)
//              .getResultList();
//      for (Member member : result) {
//        System.out.println("member.getName() = " + member.getName());
//      }

      // 5: flush 확인
      // 비영속
//      Member member = new Member();
//      member.setId(101L);
//      member.setName("HelloA");
      // 영속
//      System.out.println("=== BEFORE ===");
//      em.persist(member);
//      System.out.println("=== AFTER ===");

//      Member findMember = em.find(Member.class, 101L);
//      System.out.println("findMember.getId() = " + findMember.getId());
//      System.out.println("findMember.getName() = " + findMember.getName());

      // 1차 캐시 동등성
//      Member findMember1 = em.find(Member.class, 101L);
//      Member findMember2 = em.find(Member.class, 101L);
//      System.out.println("(findMember2 == findMember1) = " + (findMember2 == findMember1));

      // 쓰기지연 저장소 확인 및 jdbc batch 로 쿼리를 모아서, 한방에 보낼 수 있는 장점 확인
//      Member member1 = Member.builder().id(2L).name("B").build();
//      Member member2 = Member.builder().id(3L).name("C").build();
//      Team teamA = Team.builder().id(1L).name("teamA").build();
//      em.persist(teamA);
//      Team findTeam = em.find(Team.class, 1L);
//      System.out.println("findTeam = " + findTeam);
//      em.persist(member1);
//      em.persist(member2);
//      List<Member> result1 = em.createQuery("select m from Member m", Member.class)
//              .getResultList();
//      List<Member> result2 = em.createQuery("select m from Member m", Member.class)
//              .getResultList();
//      Member member3 = Member.builder().id(1L).name("A").build();
//      em.persist(member3);
//      System.out.println("=========================================");

      //  Enumerated -> EnumType.ORDINAL 사용 (x)
//      Member member1 = new Member();
//      member1.setUsername("B");
//      member1.setRoleType(RoleType.USER);
//      em.persist(member1);
//      Member member2 = new Member();
//      member2.setUsername("B");
//      member2.setRoleType(RoleType.ADMIN);
//      em.persist(member2);
//      Member member = em.find(Member.class, 6L);
//      member.setRoleType(RoleType.GUEST);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

//    transient

    emf.close();
  }
}
