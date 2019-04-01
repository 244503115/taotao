package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}
}
