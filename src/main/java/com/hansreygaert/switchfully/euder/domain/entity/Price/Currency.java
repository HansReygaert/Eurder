package com.hansreygaert.switchfully.euder.domain.entity.Price;

public enum Currency {
	EURO("EUR");
	private final String currencyType;
	Currency(String currencyType) {
		this.currencyType = currencyType;
	}
}
