package com.ashok.in.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {
	@GetMapping("/greet")
	public String greet() {
		return "Gooooooooodddddd evening";
	}

}
