package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  private String name;

//  @OneToMany(mappedBy = "member")
//  private List<Order> orders = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private Team team;

  @Embedded
  private Address address;

  public void changeTeam(Team team) {
//    if (this.team != null) this.team.getMembers().remove(this);
    Optional<Team> teamOptional = Optional.ofNullable(this.team);
    teamOptional.ifPresent(c -> {
      c.getMembers().remove(this);
    });
    this.team = team;



    Optional<Boolean> aBoolean = teamOptional.map(c -> {
      return c.getMembers().remove(this);
    });
  }

}
