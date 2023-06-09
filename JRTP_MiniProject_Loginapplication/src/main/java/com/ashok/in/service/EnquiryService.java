package com.ashok.in.service;

import java.util.List;

import com.ashok.in.binding.DashboardResponse;
import com.ashok.in.binding.EnquiryForm;
import com.ashok.in.binding.EnquirySearchCriteria;
import com.ashok.in.entities.StudentEnqEntity;

public interface EnquiryService {

	public List<String> getCourseNames();

	public List<String> getEnqStatus();

	public DashboardResponse getDashboardResponse(Integer userId);

	public boolean saveEnquiry(EnquiryForm form);
	public List<StudentEnqEntity> getEnquiries();
	public List<StudentEnqEntity> getFilteredEnquiries(EnquirySearchCriteria criteria, Integer userId);


}
