package com.ashok.in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}
	@GetMapping("/signup")
	public String signuppage() {
		return "signup";
	}
	@GetMapping("/forgotPwd")
	public String forgotpwdpage() {
		return "forgotPwd";
	}
	@GetMapping("/unlock")
	public String unlockpage() {
		return "unlock";
	}
	

}
