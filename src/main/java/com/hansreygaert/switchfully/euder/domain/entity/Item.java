package com.hansreygaert.switchfully.euder.domain.entity;

public class Item {
	private final String id;
	private final String name;
	private final String description;
	private Price price;
	private int amountInStock;

	public Item(String id, String name, String description, Price price,
	            int amountInStock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.amountInStock = amountInStock;
	}
}
