package com.hansreygaert.switchfully.euder.service;

import com.hansreygaert.switchfully.euder.domain.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
  private final ShoppingCartRepository shoppingCartRepository;

  public ShoppingCartService( ShoppingCartRepository shoppingCartRepository) {
    this.shoppingCartRepository = shoppingCartRepository;
  }


}
