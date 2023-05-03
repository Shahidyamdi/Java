package com.ashok.in.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class index {
	@GetMapping("/")
	public String indexpage() {
		return "index";
	}

}
