package com.hansreygaert.switchfully.euder.domain.repository;

import com.hansreygaert.switchfully.euder.domain.entity.Item;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

  private final Map<String, Item> itemRepository;

  @Autowired
  public ItemRepository() {
    this.itemRepository = new HashMap<>();
  }

  public void addItem(Item item) {
    itemRepository.put(item.getId(), item);
  }

  public Item getItem(String uuid) {
    return itemRepository.get(uuid);
  }

  public List<Item> getAllItems() {
    return itemRepository.values().stream().toList();
  }
}
