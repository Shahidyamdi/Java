package com.shahid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shahid.model.profile;
import com.shahid.service.profileService;

@Controller
public class profileController {
	@Autowired
	private profileService profileService;

	@GetMapping("/")
	public String showHomePage(Model model) {
		List<profile> profiles = profileService.getProfiles();
		model.addAttribute("profiles", profiles);
		return "index";
	}

	@PostMapping("/upload")
	public String uploadMultipleFiles(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("mobile") String mobile, @RequestParam("file") MultipartFile file) {
		profile profile = new profile();
		profile.setName(name);
		profile.setEmail(email);
		profile.setMobile(mobile);
		profileService.saveProfile(profile, file);
		return "redirect:/";
	}

	@GetMapping("/downloadFile/{id}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer id) {
		profile profile = profileService.getProfile(id).get();
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(profile.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment:filename=\"" + profile.getDocName() + "\"")
				.body(new ByteArrayResource(profile.getDocData()));
	}

}