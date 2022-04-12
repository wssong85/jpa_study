package hellojpa;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(sequenceName = "member_sequence_name", name = "member_name", initialValue = 1, allocationSize = 5)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_name")
  private Long id;

  private String name;

  @Builder
  public Member(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
