package com.ashok.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashok.in.controller.ReportController;

@SpringBootApplication
public class Application {
	
	@Autowired
	private ReportController reportController; 

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	   
	}

}
