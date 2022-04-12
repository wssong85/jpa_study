package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Item {

  @Id
  @GeneratedValue
  @Column(name = "item_id")
  private Long id;

  @OneToMany(mappedBy = "item")
  private List<OrderItem> orderItem = new ArrayList<>();

  private String name;

  private int price;

  private int stockQuantity;
}
