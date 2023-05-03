package com.wed.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
	private Long id;       //상품 코드

    private String itemNm; //상품명

    private int price; //가격

    private int stockNumber; 

    private String itemDetail; 

    private String itemSellStatus;
    
    private LocalDateTime regTime;
    
    private LocalDateTime updateTime;
}
