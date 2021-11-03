package com.hansreygaert.switchfully.euder.controllers;

import com.hansreygaert.switchfully.euder.dtos.ItemDtoCreate;
import com.hansreygaert.switchfully.euder.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/items")
public class ItemsController {

  private final ItemService itemService;

  @Autowired
  public ItemsController(ItemService itemService) {
    this.itemService = itemService;
  }

  // :POST (Story 2)
  @PostMapping
  @ResponseBody
  public ItemDtoCreate addItem(@RequestHeader String idToken,
      ItemDtoCreate itemDto) {

    return itemService.addItem(idToken, itemDto);
  }
  // /{itemId} :PUT

}
