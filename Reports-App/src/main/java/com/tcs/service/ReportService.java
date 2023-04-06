package com.tcs.service;

import java.util.List;

import com.tcs.entites.CitizenPlan;
import com.tcs.request.SearchRequest;

public interface ReportService {
	public List<String> getPlanName();
	public List<String> getPlanStatus();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean exportpdf();
	public boolean exportexcel();

}
