package com.wed.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.wed.constant.ItemSellStatus;
import com.wed.entity.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFormDto {
	
	private Long id;       //상품 코드
	
	@NotBlank(message = "상품명은 필수 항목입니다.")
    private String itemNm; //상품명
	
	@NotNull(message = "가격은 필수 항목입니다.")
    private Integer price; //가격
	
	@NotNull(message = "재고는 필수 항목입니다.")
    private Integer stockNumber; 
	@NotNull(message = "상품 설명은 필수 항목입니다.")
    private String itemDetail; 

    private ItemSellStatus itemSellStatus;
    
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
    
    private List<Long> itemImgIds = new ArrayList<>();
    
    private static ModelMapper modelMapper = new ModelMapper();
    
    public Item createItem() {
    	return modelMapper.map(this, Item.class);
    }
    
    public static ItemFormDto of(Item item) {
    	return modelMapper.map(item, ItemFormDto.class);
    }
}
