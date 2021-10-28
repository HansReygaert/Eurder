package com.hansreygaert.switchfully.euder.domain.entity;

import com.hansreygaert.switchfully.euder.domain.Currency;

public class Price {
	private final Currency currency;
	private final double price;

	public Price(Currency currency, double price) {
		this.currency = currency;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%.2f", price) + " " + currency.toString();
	}
}
