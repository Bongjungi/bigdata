package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/sbb")
	@ResponseBody
	public String index() {
		return "index";
	}
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/question/list";
		//redirect는 새로운 요청
		//forward는 기존 요청값 유지
	}
}
