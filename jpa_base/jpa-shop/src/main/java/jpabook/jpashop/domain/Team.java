package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

  @Id
  @GeneratedValue
  @Column(name = "team_id")
  private Long id;

  private String name;

  @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
  private List<Member> members = new ArrayList<>();

  public void addMember(Member member) {
    members.add(member);
    member.changeTeam(this);
  }
}
