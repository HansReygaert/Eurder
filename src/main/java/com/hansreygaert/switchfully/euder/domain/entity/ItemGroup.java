package com.hansreygaert.switchfully.euder.domain.entity;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
	private final String id;
	private int amount;
	private LocalDate LocalDate;

	public ItemGroup() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public int getAmount() {
		return amount;
	}

	public java.time.LocalDate getLocalDate() {
		return LocalDate;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setLocalDate(java.time.LocalDate localDate) {
		LocalDate = localDate;
	}
}
