package com.tcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entites.CitizenPlan;
import com.tcs.repo.Citizenplanrepository;
import com.tcs.request.SearchRequest;

@Service
public class serviceimpl implements ReportService {
	@Autowired
	Citizenplanrepository repo;

	@Override
	public List<String> getPlanName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exportpdf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exportexcel() {
		// TODO Auto-generated method stub
		return false;
	}

}
