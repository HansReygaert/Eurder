package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.domain.entity.Item;
import com.hansreygaert.switchfully.euder.domain.entity.ItemGroup;
import com.hansreygaert.switchfully.euder.exceptions.CustomerNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartRepository {

  public final Map<String, List<ItemGroup>> ShoppingCart;

  public ShoppingCartRepository() {
    ShoppingCart = new HashMap<>();
  }

  public void addItemGroupToShoppingCart(String customerId, ItemGroup items){
    if (customerId == null || items == null) throw new IllegalArgumentException();
    ShoppingCart.get(customerId).add(items);
  }

  public List<ItemGroup> getItemGroupsFromCustomer(String customerId){
    List<ItemGroup> itemGroup = ShoppingCart.get(customerId);
    if (itemGroup == null || customerId == null) throw new CustomerNotFoundException();

    return itemGroup;
  }



}
