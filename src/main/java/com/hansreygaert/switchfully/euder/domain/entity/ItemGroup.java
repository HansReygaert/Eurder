package com.hansreygaert.switchfully.euder.domain.entity;

import java.time.LocalDate;

public class ItemGroup {

  private final String itemId;
  private int amount;
  private LocalDate LocalDate;

  public ItemGroup(String itemId) {
    this.itemId = itemId;
  }

  public String getItemId() {
    return itemId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public java.time.LocalDate getLocalDate() {
    return LocalDate;
  }

  public void setLocalDate(LocalDate localDate) {
    LocalDate = localDate;
  }
}
