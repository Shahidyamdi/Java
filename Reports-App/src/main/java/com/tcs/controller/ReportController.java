package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.tcs.service.serviceimpl;

@Controller
public class ReportController {
	
	@Autowired
	serviceimpl serviceimpl;
	
	
	@GetMapping("/")
	public String getpage() {
		return "index";
	}
	

}
