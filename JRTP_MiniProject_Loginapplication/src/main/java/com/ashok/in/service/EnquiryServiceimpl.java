package com.ashok.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashok.in.binding.DashboardResponse;
import com.ashok.in.binding.EnquiryForm;
import com.ashok.in.binding.EnquirySearchCriteria;
import com.ashok.in.repos.EnqStatusrepo;
import com.ashok.in.repos.courserepo;

public class EnquiryServiceimpl implements EnquiryService {
	@Autowired
	courserepo courserepo;
	@Autowired
	EnqStatusrepo enqStatusrepo;
	

	@Override
	public List<String> getCourseNames() {
		return  courserepo.save(null);
	}

	@Override
	public List<String> getEnqStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DashboardResponse getDashboardResponse(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addEnquiry(EnquiryForm form) {
		return null;
	}

	@Override
	public List<EnquiryForm> getEnquries(Integer userId, EnquirySearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquiryForm getEnquiry(Integer enqId) {
		// TODO Auto-generated method stub
		return null;
	}

}
