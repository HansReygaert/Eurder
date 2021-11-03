package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.dtos.OrdersDto;
import com.hansreygaert.switchfully.euder.mappers.OrdersMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersRepository {

  private final Map<String, String> orders;

  public OrdersRepository() {
    orders = new HashMap<>();
  }

}
