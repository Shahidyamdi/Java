package com.ashok.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashok.in.binding.PostForm;
import com.ashok.in.binding.RegistrationForm;
import com.ashok.in.service.PostService;

@Controller
public class Postcontroller {
	@Autowired
	PostService service;

	@GetMapping("/allpost")
	public String mypost(Model model, PostForm form) {
		System.out.println(form);
		boolean status = service.save(form);
		model.addAttribute("user", new PostForm());
		if (status) {
			model.addAttribute("Success", "Data Created ");
		} else {
			model.addAttribute("errmsg", " Invalid");

		}

		return "allpost";
	}

	@GetMapping("/create")
	public String createpage(Model model) {
		model.addAttribute("user", new PostForm());
		return "create";
	}

	@PostMapping("/create")
	public String created(@ModelAttribute("user") PostForm form, Model model) {
		System.out.println(form);
		boolean status = service.create(form);
		if (status) {
			model.addAttribute("Success", "Data Created ");
		} else {
			model.addAttribute("errmsg", " Invalid");

		}
		return "create";

	}

}
