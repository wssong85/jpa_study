package hellojpa;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
  @Id
//  @GeneratedValue
  private Long id;

  private String name;

  @Builder
  public Team(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
