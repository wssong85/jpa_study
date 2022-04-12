package com.datajpa.repository;

import com.datajpa.entity.Member;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{

  @PersistenceContext
  private EntityManager entityManager;
  @Override
  public List<Member> findMemberCustom() {
    return entityManager.createQuery("select m from Member m").getResultList();
  }

}
