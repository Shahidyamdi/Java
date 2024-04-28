package com.ashok.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.in.fegin.feginclass;

@RestController
public class WelcomeRestController {
	
	@Autowired
	public feginclass fc;
	 
	@GetMapping("/welcome")
	public String welcome() {
		String st = this.fc .involveGreetapi();
		return  st + "Welcome Ashok IT";
	}

}
