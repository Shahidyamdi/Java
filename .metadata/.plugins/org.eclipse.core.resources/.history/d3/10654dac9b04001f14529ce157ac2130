package com.shahid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shahid.model.profile;
import com.shahid.repo.profileRepository;
@Service
public class profileService {
	@Autowired
	private profileRepository profileRepository;
	public Profile saveProfile(profile p, MultipartFile file) {
	try {
	profile profile = new profile();
	profile.setName(p.getName());
	profile.setEmail(p.getEmail());
	profile.setMobile(p.getMobile());
	profile.setDocData(file.getBytes());
	profile.setDocType(file.getContentType());
	profile.setDocName(file.getOriginalFilename());
	return (Profile) profileRepository.save(profile);
	} catch (Exception e) {
	e.printStackTrace();
	}
	return null;
	}
	public Optional<profile> getProfile(Integer id) {
	return profileRepository.findById(id);
	}
	public List<profile> getProfiles() {
	return profileRepository.findAll();
	}

}
