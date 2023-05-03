package com.wed.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.wed.constant.ItemSellStatus;
import com.wed.dto.ItemFormDto;
import com.wed.exception.OutOfStockException;
import com.wed.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity{
	@Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;       //상품 코드

    @Column(nullable = false, length = 50)
    private String itemNm; //상품명

    @Column(name="price", nullable = false)
    private int price; //가격

    @Column(nullable = false)
    private int stockNumber; //재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;
    
    public void updateItem(ItemFormDto itemFormDto) {
    	this.itemNm = itemFormDto.getItemNm();
    	this.price = itemFormDto.getPrice();
    	this.stockNumber=itemFormDto.getStockNumber();
    	this.itemDetail=itemFormDto.getItemDetail();
    	this.itemSellStatus=itemFormDto.getItemSellStatus();
    	
    }
    
    public void removeStock(int stockNumber) {
    	int restStock = this.stockNumber - stockNumber;
    	if(restStock<0) {
    		throw new OutOfStockException("상품의 재고가 부족합니다.");
    	}
    	this.stockNumber=restStock;
    }
    public void addStock(int stockNumber) {
    	this.stockNumber+=stockNumber;
    }
}
