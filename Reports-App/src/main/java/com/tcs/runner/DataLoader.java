package com.tcs.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tcs.entites.CitizenPlan;
import com.tcs.repo.Citizenplanrepository;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	Citizenplanrepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		/*
		 * // cash data CitizenPlan c1 = new CitizenPlan(); c1.setCitizenName("john");
		 * c1.setGender("male"); c1.setPlanName("cash"); c1.setPlanStatus("approved");
		 * c1.setPlanStartDate(LocalDate.now());
		 * c1.setEndStartDate(LocalDate.now().plusMonths(6));
		 * c1.setBenefitAmt(50000.00);
		 * 
		 * 
		 * CitizenPlan c2 = new CitizenPlan(); c2.setCitizenName("bruh");
		 * c2.setGender("male"); c2.setPlanName("cash"); c2.setPlanStatus("Denied");
		 * c2.setDenialReason("income resource");
		 * 
		 * CitizenPlan c3 = new CitizenPlan(); c3.setCitizenName("caty");
		 * c3.setGender("female"); c3.setPlanName("cash");
		 * c3.setPlanStatus("terminated"); c3.setDenialReason("employed");
		 * 
		 * // food data
		 * 
		 * CitizenPlan c4 = new CitizenPlan(); c4.setCitizenName("lee");
		 * c4.setGender("male"); c4.setPlanName("food"); c4.setPlanStatus("approved");
		 * c4.setPlanStartDate(LocalDate.now());
		 * c4.setEndStartDate(LocalDate.now().plusMonths(6));
		 * c4.setBenefitAmt(50000.00);
		 * 
		 * 
		 * 
		 * 
		 * CitizenPlan c5 = new CitizenPlan(); c5.setCitizenName("brucee");
		 * c5.setGender("male"); c5.setPlanName("food"); c5.setPlanStatus("Denied");
		 * c5.setDenialReason("income resource");
		 * 
		 * 
		 * CitizenPlan c6 = new CitizenPlan(); c6.setCitizenName("gal");
		 * c6.setGender("female"); c6.setPlanName("food");
		 * c6.setPlanStatus("terminated"); c6.setDenialReason("employed");
		 * 
		 * 
		 * // medical data CitizenPlan c7 = new CitizenPlan();
		 * c7.setCitizenName("ratan"); c7.setGender("male"); c7.setPlanName("medical");
		 * c7.setPlanStatus("approved"); c7.setPlanStartDate(LocalDate.now());
		 * c7.setEndStartDate(LocalDate.now().plusMonths(6));
		 * c7.setBenefitAmt(50000.00);
		 * 
		 * 
		 * CitizenPlan c8 = new CitizenPlan(); c8.setCitizenName("gautham");
		 * c8.setGender("male"); c8.setPlanName("medical"); c8.setPlanStatus("Denied");
		 * c8.setDenialReason("income resource");
		 * 
		 * 
		 * CitizenPlan c9 = new CitizenPlan(); c9.setCitizenName("anu");
		 * c9.setGender("female"); c9.setPlanName("medical");
		 * c9.setPlanStatus("terminated"); c9.setDenialReason("employed");
		 * 
		 * 
		 * 
		 * // employement data CitizenPlan c10 = new CitizenPlan();
		 * c10.setCitizenName("shahid"); c10.setGender("male");
		 * c10.setPlanName("Employement"); c10.setPlanStatus("approved");
		 * c10.setPlanStartDate(LocalDate.now());
		 * c10.setEndStartDate(LocalDate.now().plusMonths(6));
		 * c10.setBenefitAmt(50000.00);
		 * 
		 * 
		 * 
		 * CitizenPlan c11 = new CitizenPlan(); c11.setCitizenName("steve");
		 * c11.setGender("male"); c11.setPlanName("Employement");
		 * c11.setPlanStatus("Denied"); c11.setDenialReason("income resource");
		 * 
		 * 
		 * 
		 * CitizenPlan c12 = new CitizenPlan(); c12.setCitizenName("anushka");
		 * c12.setGender("female"); c12.setPlanName("Employement");
		 * c12.setPlanStatus("terminated"); c12.setDenialReason("employed");
		 * 
		 * List<CitizenPlan> list =
		 * Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12); repo.saveAll(list);
		 * 
		 */
		
		
	
	
	
	}

}
