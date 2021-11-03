package com.hansreygaert.switchfully.euder.domain.entity.Price;

public class Price {

  private final Currency currency;
  private final double value;

  public Price(Currency currency, double value) {
    this.currency = currency;
    this.value = value;
  }

  public Currency getCurrency() {
    return currency;
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("%.2f", value) + " " + currency.toString();
  }
}
