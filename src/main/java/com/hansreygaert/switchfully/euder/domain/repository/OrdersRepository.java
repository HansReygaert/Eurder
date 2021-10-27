package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.dtos.OrdersDto;
import com.hansreygaert.switchfully.euder.mappers.OrdersMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrdersRepository {
	private final Map<String,String> orders;

	public OrdersRepository() {
		orders = new HashMap<>();
	}

	public OrdersDto addOrder(String userId, String ordersId){
		orders.put(userId,ordersId);
		return OrdersMapper.getOrdersDto(userId,ordersId);
	}
}
