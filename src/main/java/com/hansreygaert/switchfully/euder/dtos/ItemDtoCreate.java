package com.hansreygaert.switchfully.euder.dtos;

public final class ItemDtoCreate {

  private final String name;
  private final String description;
  private final String priceCurrency;
  private final String priceValue;
  private final String amount;

  public ItemDtoCreate(
      String name,
      String description,
      String priceValue,
      String priceCurrency,
      String amount
  ) {
    this.name = name;
    this.description = description;
    this.priceCurrency = priceCurrency;
    this.priceValue = priceValue;
    this.amount = amount;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getPrice() {
    return priceValue + " " + priceCurrency;
  }

  public String getPriceCurrency() {
    return priceCurrency;
  }

  public String getPriceValue() {
    return priceValue;
  }

  public String getAmount() {
    return amount;
  }

}
