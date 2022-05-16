package hellojpa;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Entity
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "USERNAME")
  private String username;

  @Column(name = "TEAM_ID")
  private Long teamId;
}
