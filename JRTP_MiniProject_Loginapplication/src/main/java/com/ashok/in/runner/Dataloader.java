package com.ashok.in.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ashok.in.entities.EnqStatusEntity;
import com.ashok.in.entities.courseEntity;
import com.ashok.in.repos.EnqStatusrepo;
import com.ashok.in.repos.courserepo;

@Component
public class Dataloader implements ApplicationRunner {
	@Autowired
	courserepo courserepo;
	@Autowired
	EnqStatusrepo enqStatusRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		courserepo.deleteAll();

		courseEntity c1 = new courseEntity();

		c1.setCourseName("java");

		courseEntity c2 = new courseEntity();

		c2.setCourseName("python");

		courseEntity c3 = new courseEntity();

		c3.setCourseName("Devops");

		courserepo.saveAll(Arrays.asList(c1, c2, c3));

		enqStatusRepo.deleteAll();

		EnqStatusEntity e1 = new EnqStatusEntity();

		e1.setStatusName("New");

		EnqStatusEntity e2 = new EnqStatusEntity();

		e2.setStatusName("Enrolled");

		EnqStatusEntity e3 = new EnqStatusEntity();

		e3.setStatusName("Lost");

		enqStatusRepo.saveAll(Arrays.asList(e1, e2, e3));

	}

}