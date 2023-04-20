package com.ashok.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashok.in.binding.SignupForm;
import com.ashok.in.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}

	@GetMapping("/signup")
	public String signuppage(Model model) {
		model.addAttribute("user", new SignupForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String handlesignup(@ModelAttribute("user") SignupForm form, Model model) {
		boolean status = userService.signup(form);
		if (status) {
			model.addAttribute("Success", "Account Created ! check Your Mail");
		} else {
			model.addAttribute("errmsg", " choose Unique Mail");

		}
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
