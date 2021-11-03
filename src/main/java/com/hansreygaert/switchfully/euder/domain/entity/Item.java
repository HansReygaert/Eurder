package com.hansreygaert.switchfully.euder.domain.entity;

import com.hansreygaert.switchfully.euder.domain.entity.Price.Price;
import java.util.UUID;

public class Item {

  private final String id;
  private final String name;
  private final String description;
  private Price price;
  private int amountInStock;

  public Item(String name, String description, Price price,
      int amountInStock) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.description = description;
    this.price = price;
    this.amountInStock = amountInStock;
  }


  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public int getAmountInStock() {
    return amountInStock;
  }

  public void setAmountInStock(int amountInStock) {
    this.amountInStock = amountInStock;
  }
}
