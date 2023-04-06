package com.tcs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.entites.CitizenPlan;

@Repository
public interface Citizenplanrepository extends JpaRepository<CitizenPlan, Integer> {
	@Query("select distinct (planName) from CitizenPlan")
	public List<String> getPlanName();
	
	@Query("select distinct (planStatus) from CitizenPlan")
	public List<String> getPlanStatus();
	

}
