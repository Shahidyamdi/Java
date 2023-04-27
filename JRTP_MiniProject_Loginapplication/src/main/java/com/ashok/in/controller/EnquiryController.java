package com.ashok.in.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ashok.in.binding.DashboardResponse;
import com.ashok.in.binding.EnquiryForm;
import com.ashok.in.service.EnquiryService;

@Controller
public class EnquiryController {
	@Autowired
	private HttpSession session;

	@Autowired
	EnquiryService enqService;

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();

		return "index";

	}

	@GetMapping("/dashboard")
	public String dashboardpage(Model model) {
		System.out.println("dashboard calling");
		Integer userId = (Integer) session.getAttribute("userId");
		DashboardResponse dashboarddata = enqService.getDashboardResponse(userId);

		model.addAttribute("dashboarddata", dashboarddata);

		return "dashboard";

	}

	@GetMapping("/enquiry")
	public String addenquirypage(Model model) {
		List<String> course = enqService.getCourseNames();
		List<String> enqstatus = enqService.getCourseNames();
		EnquiryForm formobj = new EnquiryForm();
		model.addAttribute("courseNames", course);
		model.addAttribute("enqstatuses", enqstatus);
		model.addAttribute("formobj", formobj);

		return "add-enquiry";

	}

	@GetMapping("/enquires")
	public String viewenquirypage() {
		return "view-enquires";

	}

}
