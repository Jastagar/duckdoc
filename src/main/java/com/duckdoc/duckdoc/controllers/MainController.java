package com.duckdoc.duckdoc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	
	@RequestMapping("hi")
	public String homeRoute() {
		return "hello";
	}
}
