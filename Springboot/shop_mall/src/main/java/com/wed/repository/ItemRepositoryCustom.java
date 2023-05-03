package com.wed.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wed.dto.ItemSearchDto;
import com.wed.dto.MainItemDto;
import com.wed.entity.Item;

public interface ItemRepositoryCustom {
	
	Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
	Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
	
}
