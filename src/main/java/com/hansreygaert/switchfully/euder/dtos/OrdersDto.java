package com.hansreygaert.switchfully.euder.dtos;

public final class OrdersDto {

  private final String userId;
  private final String ordersId;
  private final String amount;
  private final String priceTotalCost;
  private final String currencyOfPrice;
  private final String shippingDate;

  public OrdersDto(String userId, String ordersId, String amount, String priceTotalCost,
      String currencyOfPrice, String shippingDate) {
    this.userId = userId;
    this.ordersId = ordersId;
    this.amount = amount;
    this.priceTotalCost = priceTotalCost;
    this.currencyOfPrice = currencyOfPrice;
    this.shippingDate = shippingDate;
  }

  public String getUserId() {
    return userId;
  }

  public String getOrdersId() {
    return ordersId;
  }
}