package com.wed.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wed.dto.ItemSearchDto;
import com.wed.entity.Item;

public interface ItemRepositoryCustom {
	
	Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
