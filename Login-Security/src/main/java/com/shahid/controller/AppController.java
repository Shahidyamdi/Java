package com.shahid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shahid.model.User;
import com.shahid.repo.UserRepository;
@Controller
public class AppController {
	@Autowired
	private UserRepository userRepo;

	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/process_register")
	public String processRegister(User user, Model model) {
		User existedUser = userRepo.findByEmail(user.getEmail());
		String existedEmail = "";
		if (existedUser != null) {
			existedEmail = existedUser.getEmail();
		}
		if (user.getEmail().equals(existedEmail)) {
			model.addAttribute("existedUser", existedEmail);
			return "registration";
		} else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);

			userRepo.save(user);
			return "registration_success";
		}
	}

	@GetMapping("/login")
	public String viewLoginPage() {
		return "login";
	}

	@GetMapping("/profile")
	public String showProfilePage() {
		return "profile";

	}
}
