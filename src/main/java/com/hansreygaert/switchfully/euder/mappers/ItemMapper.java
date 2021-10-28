package com.hansreygaert.switchfully.euder.mappers;

import com.hansreygaert.switchfully.euder.domain.entity.Item;
import com.hansreygaert.switchfully.euder.dtos.ItemDtoBasicInformation;
import com.hansreygaert.switchfully.euder.dtos.ItemDtoCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;


public class ItemMapper {
	private static final Logger logger =
			  LoggerFactory.getLogger(ItemMapper.class);

	public static ItemDtoBasicInformation getItemBasicInfoDto(Item item){
		return new ItemDtoBasicInformation(
				  item.getName(), item.getPrice(), item.getDescription()
		);
	}
	public static ItemDtoCreate getItemDtoCreate(Item item){
		return new ItemDtoCreate(
				  item.getName(),
				  item.getDescription(), item.getPrice(),
				  String.valueOf(item.getAmountInStock())
		);
	}
	public static Item getItemFromDtoCreate(ItemDtoCreate itemDto){
		try{
		return new Item(
				  itemDto.name(), itemDto.Description(), itemDto.Price(),
				  Integer.parseInt(itemDto.Amount())
				  );
		} catch(NumberFormatException exception){
			logger.error("Getting invalid integers parsed form a DTO," +
					  " is someone messing with the data ? ");
			logger.error(exception.getMessage());
			logger.error(Arrays.toString(exception.getStackTrace()));

			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
	}
}
