package com.datajpa.repository;

import com.datajpa.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
  List<Member> findMemberCustom();
}
