package com.hansreygaert.switchfully.euder.dtos;

public final class IdentificationDto {

  private final String token;

  public IdentificationDto(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
