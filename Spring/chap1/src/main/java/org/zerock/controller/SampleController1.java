package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController1 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController1.class);
	//localhost:8080/doA?msg=BB
	@RequestMapping("/doA")
	public String doA(@ModelAttribute("msg") String msg) {
		logger.info("doA called");
		return "result";
	}
	
	@RequestMapping("/doB")
	public String doB(RedirectAttributes rttr) {
		logger.info("doB called");
		rttr.addFlashAttribute("msg","this is msg");
		return "redirect:/doC";
	}
	
	@RequestMapping("/doC")
	public String doC(String msg) {
		logger.info("doC called");
		return "result2";
	}
}
