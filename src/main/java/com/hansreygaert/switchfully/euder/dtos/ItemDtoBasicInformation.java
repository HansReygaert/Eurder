package com.hansreygaert.switchfully.euder.dtos;

import java.util.Objects;

public final class ItemDtoBasicInformation {

  private final String name;
  private final String price;
  private final String description;

  public ItemDtoBasicInformation(
      String name,
      String price,
      String description
      // String stockLevel
  ) {
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public String name() {
    return name;
  }

  public String price() {
    return price;
  }

  public String description() {
    return description;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    var that = (ItemDtoBasicInformation) obj;
    return Objects.equals(this.name, that.name) &&
        Objects.equals(this.price, that.price) &&
        Objects.equals(this.description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price, description);
  }

  @Override
  public String toString() {
    return "ItemDtoBasicInformation[" +
        "name=" + name + ", " +
        "price=" + price + ", " +
        "description=" + description + ']';
  }

}
