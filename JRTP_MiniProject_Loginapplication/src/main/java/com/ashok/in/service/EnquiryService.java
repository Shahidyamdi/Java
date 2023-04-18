package com.ashok.in.service;

import java.util.List;

import com.ashok.in.binding.DashboardResponse;
import com.ashok.in.binding.EnquiryForm;
import com.ashok.in.binding.EnquirySearchCriteria;

public interface EnquiryService {

	public List<String> getCourseNames();

	public List<String> getEnqStatus();

	public DashboardResponse getDashboardResponse(Integer userId);

	public String addEnquiry(EnquiryForm form);

	public List<EnquiryForm> getEnquries(Integer userId, EnquirySearchCriteria criteria);

	public EnquiryForm getEnquiry(Integer enqId);
}
