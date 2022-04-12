package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ORDER_ITEM_ID")
  private Long id;

  @Column(name = "ORDER_ID")
  private Long orderId;

  @Column(name = "ITEM_ID")
  private Long itemId;

  private int orderPrice;

  private int count;
}
