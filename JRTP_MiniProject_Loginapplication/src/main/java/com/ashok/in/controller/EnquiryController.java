package com.ashok.in.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashok.in.binding.DashboardResponse;
import com.ashok.in.binding.EnquiryForm;
import com.ashok.in.binding.EnquirySearchCriteria;
import com.ashok.in.entities.StudentEnqEntity;
import com.ashok.in.repos.StudentEnqrepo;
import com.ashok.in.service.EnquiryService;

@Controller
public class EnquiryController {
	@Autowired
	private HttpSession session;

	@Autowired
	EnquiryService enqService;
	@Autowired
	StudentEnqrepo studentEnqRepo;

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
	public String addEnquiryPage(Model model) {

		initForm(model);

		return "add-enquiry";
	}

	private void initForm(Model model) {
		// get courses for the drop down
		List<String> courseNames = enqService.getCourseNames();
		// get enq status for drop down
		List<String> enqStatus = enqService.getEnqStatus();
		// create binding class object
		EnquiryForm formObj = new EnquiryForm();
		// set data in model object
		model.addAttribute("courseName", courseNames);
		model.addAttribute("StatusNames", enqStatus);
		model.addAttribute("formObj", formObj);
	}

	@PostMapping("/addEnq")
	public String addEnquiry(@ModelAttribute("formObj") EnquiryForm formObj, Model model) {
		System.out.println(formObj);

		Boolean status = enqService.saveEnquiry(formObj);

		if (status) {
			model.addAttribute("succMsg", "Enquiry Added");
		} else {
			model.addAttribute("errMsg", "Problem Occured");
		}

		return "add-enquiry";
	}

	@GetMapping("/enquires")
	public String viewEnquiriesPage(Model model) {
		initForm(model);
		List<StudentEnqEntity> enquires = enqService.getEnquiries();

		model.addAttribute("enquiries", enquires);

		return "view-enquiries";
	}

	@GetMapping("/filter-enquiries")
	public String getFilteredEnqs(@RequestParam String cname, @RequestParam String status, @RequestParam String mode,
			Model model) {

		EnquirySearchCriteria criteria = new EnquirySearchCriteria();
		criteria.setCourseName(cname);
		criteria.setEnqStatus(status);
		criteria.setClassMode(mode);

		System.out.println(criteria);

		Integer userId = (Integer) session.getAttribute("userId");

		List<StudentEnqEntity> filteredEnqs = enqService.getFilteredEnquiries(criteria, userId);

		model.addAttribute("enquiries", filteredEnqs);

		return "filter-enquiries";
	}

	@GetMapping("/edit")
	public String editEnq(@RequestParam("enquiryId") Integer enquiryId, Model model) {

		Optional<StudentEnqEntity> findById = studentEnqRepo.findById(enquiryId);

		if (findById.isPresent()) {

			StudentEnqEntity studentEnqEntity = findById.get();

			// get courses for the drop down
			List<String> courseNames = enqService.getCourseNames();
			// get enq status for drop down
			List<String> enqStatus = enqService.getEnqStatus();
			// create binding class object
			EnquiryForm formObj = new EnquiryForm();

			BeanUtils.copyProperties(studentEnqEntity, formObj);

			// set data in model object
			model.addAttribute("courseName", courseNames);
			model.addAttribute("StatusNames", enqStatus);
			model.addAttribute("formObj", formObj);

		}

		return "add-enquiry";
	}

}
