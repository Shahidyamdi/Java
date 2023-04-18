package com.ashok.in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	@GetMapping("/dashboard")
	public String dashboardpage() {
		return "dashboard";
		
	}
	@GetMapping("/enquiry")
	public String addenquirypage() {
		return "add-enquiry";
		
	}
	@GetMapping("/enquires")
	public String viewenquirypage() {
		return "view-enquires";
		
	}

}
