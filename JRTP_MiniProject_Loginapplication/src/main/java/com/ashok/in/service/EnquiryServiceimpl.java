package com.ashok.in.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
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
import com.ashok.in.repos.StudentEnqrepo;
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
	@Autowired
	StudentEnqrepo enqrepo;

	@Autowired
	HttpSession session;

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
		for (EnqStatusEntity entity : findAll) {
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
			response.setLostCnt(lostcnt);
		}

		return response;
	}

	@Override
	public boolean saveEnquiry(EnquiryForm form) {
		StudentEnqEntity enqentity = new StudentEnqEntity();
		BeanUtils.copyProperties(form, enqentity);
		Integer userId = (Integer) session.getAttribute("userId");
		UserDtlsEntity userentity = userDtlsrepo.findById(userId).get();
		enqentity.setUser(userentity);
		enqrepo.save(enqentity);
		return true;
	}

	@Override
	public List<StudentEnqEntity> getEnquiries() {
		Integer userId = (Integer) session.getAttribute("userId");
		Optional<UserDtlsEntity> findById = userDtlsrepo.findById(userId);
		if (findById.isPresent()) {
			UserDtlsEntity userDtlsEntity = findById.get();
			List<StudentEnqEntity> enquiries = userDtlsEntity.getEnquiries();
			return enquiries;
		}
		return null;

	}

	@Override
	public List<StudentEnqEntity> getFilteredEnquiries(EnquirySearchCriteria criteria, Integer userId) {
		Optional<UserDtlsEntity> findById = userDtlsrepo.findById(userId);

		if (findById.isPresent()) {
			UserDtlsEntity userDetailsEntity = findById.get();
			List<StudentEnqEntity> enquiries = userDetailsEntity.getEnquiries();

			// Java 8 Stream filter logic filter logic for course
			if (criteria.getCourseName() != null & !criteria.getCourseName().equals("")) {

				enquiries = enquiries.stream().filter(e -> e.getCourseName().equals(criteria.getCourseName()))
						.collect(Collectors.toList());
			}

			// Java 8 Stream filter logic filter logic for course
			if (criteria.getEnqStatus() != null & !criteria.getEnqStatus().equals("")) {
				enquiries = enquiries.stream().filter(e -> e.getEnqStatus().equals(criteria.getEnqStatus()))
						.collect(Collectors.toList());
			}

			// Java 8 Stream filter logic filter logic for mode
			if (criteria.getClassMode() != null & !criteria.getClassMode().equals("")) {
				enquiries = enquiries.stream().filter(e -> e.getClassMode().equals(criteria.getClassMode()))
						.collect(Collectors.toList());
			}

			return enquiries;
		}

		return null;
	}

}
