package com.ashok.in.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.in.binding.DashboardResponse;
import com.ashok.in.binding.EnquiryForm;
import com.ashok.in.binding.EnquirySearchCriteria;
import com.ashok.in.entities.EnqStatusEntity;
import com.ashok.in.entities.StudentEnqEntity;
import com.ashok.in.entities.UserDtlsEntity;
import com.ashok.in.entities.courseEntity;
import com.ashok.in.repos.EnqStatusrepo;
import com.ashok.in.repos.UserDtlsrepo;
import com.ashok.in.repos.courserepo;
@Service
public class EnquiryServiceimpl implements EnquiryService {
	@Autowired
	courserepo courserepo;
	@Autowired
	EnqStatusrepo statusrepo;
	@Autowired
	UserDtlsrepo userDtlsrepo;

	@Override
	public List<String> getCourseNames() {
		List<courseEntity> findAll = courserepo.findAll();
		List<String> names = new ArrayList<>();
		
		for (courseEntity entity : findAll) {
			names.add(entity.getCourseName());
			
		}
		return names;
	}

	@Override
	public List<String> getEnqStatus() {
		List<EnqStatusEntity> findAll = statusrepo.findAll();
		List<String> status = new ArrayList<>();
		for (EnqStatusEntity entity :  findAll) {
			status.add(entity.getStatusName());
			;
			
		}
		return status;
	}

	@Override
	public DashboardResponse getDashboardResponse(Integer userId) {
		DashboardResponse response = new DashboardResponse();
		Optional<UserDtlsEntity> findById = userDtlsrepo.findById(userId);
		if (findById.isPresent()) {
			UserDtlsEntity entity = findById.get();
			List<StudentEnqEntity> enquiries = entity.getEnquiries();
			Integer totalcnt = enquiries.size();

			Integer enrolledcnt = enquiries.stream().filter(e -> e.getEnqStatus().equalsIgnoreCase("Enrolled"))
					.collect(Collectors.toList()).size();
			Integer lostcnt = enquiries.stream().filter(e -> e.getEnqStatus().equalsIgnoreCase("Lost"))
					.collect(Collectors.toList()).size();
			
			response.setTotalEnquriesCnt(totalcnt);
			response.setEnrolledCnt(enrolledcnt);
			response.setLostCnt(lostcnt);		}

		return response;
	}

	@Override
	public boolean saveEnquiry(EnquiryForm form) {
		return true;
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
