package hellojpa;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
// 오라클의 경우 SEQ 전략으로 사용
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
  private Long id;

  //  nullable => null 값의 허용 여부
//  updatable = false => db 에서는 절대 변경 x
  @Column(name = "name")
  private String username;

  private Integer age;

  @Enumerated(EnumType.ORDINAL)
  private RoleType roleType;

  @Lob
  private String description;

  @Transient // 메모리에서만 사용 (db는 상관 x)
  private int temp;
}
