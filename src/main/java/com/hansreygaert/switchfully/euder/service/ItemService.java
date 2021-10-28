package com.hansreygaert.switchfully.euder.service;

import com.hansreygaert.switchfully.euder.domain.repository.ItemRepository;
import com.hansreygaert.switchfully.euder.dtos.ItemDtoCreate;
import com.hansreygaert.switchfully.euder.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class ItemService {
	private final SecurityService securityService;
	private final ItemRepository itemRepository;

	@Autowired
	public ItemService(SecurityService securityService,
	                   ItemRepository itemRepository) {
		this.securityService = securityService;
		this.itemRepository = itemRepository;
	}

	public ItemDtoCreate addItem(String idToken, ItemDtoCreate itemDto){
		if (!securityService.isAdmin(idToken)) return null;

		itemRepository.addItem(
				  ItemMapper.getItemFromDtoCreate(itemDto)
		);
		return itemDto;
	}
}
