package com.hansreygaert.switchfully.euder.controllers;

import com.hansreygaert.switchfully.euder.domain.repository.ShoppingCartRepository;
import com.hansreygaert.switchfully.euder.dtos.ShoppingCartDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {
  private final ShoppingCartRepository shoppingCartRepository;

  public ShoppingCartController(
      ShoppingCartRepository shoppingCartRepository) {
    this.shoppingCartRepository = shoppingCartRepository;
  }

  @PostMapping(consumes = "application/json" ,produces="application/json")
  @ResponseBody
  public ShoppingCartDto addToShoppingCart(@RequestHeader(value = "uuid") String AuthenticationToken, int amount){

    return null;
  }
}
