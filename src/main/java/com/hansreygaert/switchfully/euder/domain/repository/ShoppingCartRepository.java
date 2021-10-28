package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.domain.entity.Item;

import java.util.List;
import java.util.Map;

public class ShoppingCartRepository {
	public final Map<String, List<Item>> ShoppingCart;


	public ShoppingCartRepository(Map<String, List<Item>> shoppingCart) {ShoppingCart = shoppingCart;}
}
