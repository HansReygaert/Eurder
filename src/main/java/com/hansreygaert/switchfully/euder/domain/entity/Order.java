package com.hansreygaert.switchfully.euder.domain.entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {

  private final Map<String, ItemGroup> itemGroups;
  private int amount;
  private LocalDate shippingDate;


  public Order() {
    itemGroups = new HashMap();
    amount = 0;
  }





}
