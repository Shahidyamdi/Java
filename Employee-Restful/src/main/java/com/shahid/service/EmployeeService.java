package com.shahid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shahid.model.Employee;
import com.shahid.repo.EmployeeRepository;
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	}

	public List<Employee> getEmployees() {
		return repo.findAll();
	}

	public Optional<Employee> getEmployee(Integer id) {
		return repo.findById(id);
	}

	public void updateEmployee(Employee e) {
		repo.save(e);
	}

	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}
}
