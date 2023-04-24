package com.ashok.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashok.in.binding.SignupForm;
import com.ashok.in.binding.UnlockForm;
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
	public String unlockpage(@RequestParam String email, Model model) {
		UnlockForm unlockFormObj = new UnlockForm();
		unlockFormObj.setEmail(email);

		model.addAttribute("unlock", new UnlockForm());
		return "unlock";
	}

	@PostMapping("/unlock")
	public String unlockHandler(@ModelAttribute("unlock") UnlockForm unlock, Model model) {
		System.out.println(unlock);
		if (unlock.getNewPwd().equals(unlock.getConfirmPwd())) {
			boolean status = userService.unlock(unlock);
			if (status) {
				
				model.addAttribute("successmsg", "your account  unlocked");

			} else {
				model.addAttribute("errmsg", "Given temporary pwd is incorrect");

			}
		} else {
			model.addAttribute("errmsg", "New pwd and confirm pwd should be same");
		}
		return "unlock";

	}

}
