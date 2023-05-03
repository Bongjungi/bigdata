package com.wed.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wed.dto.ItemDto;

import lombok.extern.log4j.Log4j2;
@RequestMapping(value = "ex")
@Controller
@Log4j2
public class TestController {
	
	@GetMapping(value={"/a","/aa"})
	public String a(Model model) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemDetail("상품 상세 설명");
		itemDto.setItemNm("테스트 상품 1");
		itemDto.setPrice(10000);
		itemDto.setRegTime(LocalDateTime.now());
		
		model.addAttribute("itemDto",itemDto);
		
		return "ex/a";
	}
	@GetMapping(value="/a1")
	public String a1(Model model) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemDetail("상품 상세 설명");
		itemDto.setItemNm("테스트 상품 2");
		itemDto.setPrice(10200);
		itemDto.setRegTime(LocalDateTime.now());
		
		model.addAttribute("itemDto",itemDto);
		
		return "ex/a";
	}
	
	
	@GetMapping(value={"/b","/b2"})
	public void b(Model model) {
		List<ItemDto> list = new ArrayList<>();
		for(int i=1;i<11;i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("상품 상세 설명"+i);
			itemDto.setItemNm("테스트 상품"+i);
			itemDto.setPrice(10000+i);
			itemDto.setRegTime(LocalDateTime.now());
			list.add(itemDto);
		}
		model.addAttribute("list",list);
	}
	@GetMapping(value = "/c")
	public void c(@RequestParam("param1")String p1, String param2, Model model) {
		log.info("===========>"+p1+", "+param2);
		model.addAttribute("param1",p1);
		model.addAttribute("param2",param2);
		
	}
	@GetMapping(value = "/d")
	public void d() {
		
	}
}
