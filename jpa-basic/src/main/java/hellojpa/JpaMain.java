package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member member1 = Member.builder()
          .name("A")
          .build();
      em.persist(member1);

      Member member2 = Member.builder()
          .name("A")
          .build();
      em.persist(member2);

      Member member3 = Member.builder()
          .name("A")
          .build();
      em.persist(member3);

//      Member member = em.find(Member.class, 38L);
//      member.setName("AA");
//      System.out.println("=====================");
//      em.detach(member);
//      Member member2 = em.find(Member.class, 38L);
//      System.out.println("member2.toString() = " + member2.toString());

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }

    emf.close();
  }
}
