package com.hansreygaert.switchfully.euder.service;

import com.hansreygaert.switchfully.euder.domain.entity.Price.Currency;
import com.hansreygaert.switchfully.euder.domain.repository.ItemRepository;
import com.hansreygaert.switchfully.euder.dtos.ItemDtoCreate;
import com.hansreygaert.switchfully.euder.exceptions.ItemUnexpectedBodyException;
import com.hansreygaert.switchfully.euder.mappers.ItemMapper;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

  private final SecurityService securityService;
  private final ItemRepository itemRepository;
  private final Logger logger = LoggerFactory.getLogger(ItemService.class);

  @Autowired
  public ItemService(SecurityService securityService,
      ItemRepository itemRepository) {
    this.securityService = securityService;
    this.itemRepository = itemRepository;
  }

  public ItemDtoCreate addItem(String idToken, ItemDtoCreate itemDto) {
		if (securityService.isAdmin(idToken)) {
			return null;
		}

    itemRepository.addItem(
        ItemMapper.getItemFromDtoCreate(itemDto)
    );
    return itemDto;
  }

  private boolean isValidItemDtoCreate(ItemDtoCreate itemDto) {
    isValidAmount(itemDto.getAmount());
    isValidPrice(itemDto.getPriceValue(), itemDto.getPriceValue());
    return true;
  }

  private void isValidPrice(String value, String currency) {
    isValidValue(value);

  }

  private void isValidCurrency(String currency) {
		if (Arrays.stream(Currency.values())
				.noneMatch(currencies -> currencies.toString().equals(currency))) {
			throw new ItemUnexpectedBodyException();
		}
  }

  private void isValidValue(String value) {
    try {
      Double.parseDouble(value);
    } catch (NumberFormatException ex) {
      logger.warn("Item contains invalid properties");
      logger.warn(ex.getMessage());
      logger.warn(Arrays.toString(ex.getStackTrace()));
      throw new ItemUnexpectedBodyException();
    }
  }

  private void isValidAmount(String amount) {
    try {
      Integer.parseInt(amount);
    } catch (NumberFormatException ex) {
      logger.warn("Item contains invalid properties");
      logger.warn(ex.getMessage());
      logger.warn(Arrays.toString(ex.getStackTrace()));
      throw new ItemUnexpectedBodyException();
    }
  }
}
