package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.Team;

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

//            Book book = new Book();
//            book.setName("자바 표준 ORM 프로그래밍");
//            book.setAuthor("김영한");
//            em.persist(book);

            // 단방향 매핑 => application 개발 시 문제는 없다. persist 만 한번 더 함.
            // 양방향 매핑 =>
            // 1. order만 조회 시 orderItem도 알고 싶다면, 편리성을 위해 양방향해줌
            // 2. jpql 시...

//            Order order = new Order();
//            em.persist(order);
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);

//            Order order = new Order();
//            order.addOrderItem(orderItem);
//            em.persist(order);

            Member member1 = new Member();
            member1.setName("member1");
            Member member2 = new Member();
            member2.setName("member2");
            Team team1 = new Team();
            team1.setName("team1");
            team1.addMember(member1);
            team1.addMember(member2);

            em.persist(team1);
//            member1.changeTeam(team);
//            em.flush();
//            em.clear();
//            Member member2 = em.find(Member.class, member1.getId());
//            System.out.println("member2.getId() = " + member2.getId());
//            System.out.println("member2.getName() = " + member2.getName());
//            System.out.println("member2.getTeam().getName() = " + member2.getTeam().getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
