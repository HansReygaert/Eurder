package com.hansreygaert.switchfully.euder.mappers;

import com.hansreygaert.switchfully.euder.dtos.OrdersDto;

public class OrdersMapper {
	public static OrdersDto getOrdersDto(String userId, String ordersId){
		return new OrdersDto(userId,ordersId);
	}
}
