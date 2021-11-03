package com.hansreygaert.switchfully.euder.mappers;

import com.hansreygaert.switchfully.euder.domain.entity.Item;
import com.hansreygaert.switchfully.euder.dtos.ItemDtoBasicInformation;
import com.hansreygaert.switchfully.euder.dtos.ItemDtoCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemMapper {

  private static final Logger logger = LoggerFactory.getLogger(ItemMapper.class);

  public static ItemDtoBasicInformation getItemBasicInfoDto(Item item) {
    return new ItemDtoBasicInformation(item.getName(), item.getPrice().toString(),
        item.getDescription());
  }

  public static ItemDtoCreate getItemDtoCreate(Item item) {
    return new ItemDtoCreate(item.getName(), item.getDescription(),
        String.valueOf(item.getPrice().getValue()),
        item.getPrice().getCurrency().toString(), String.valueOf(item.getAmountInStock()));

  }

  public static Item getItemFromDtoCreate(ItemDtoCreate itemDto) {
    return null;
  }
}
