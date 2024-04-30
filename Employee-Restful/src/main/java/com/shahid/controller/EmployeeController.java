package com.shahid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shahid.model.Employee;
import com.shahid.service.EmployeeService;
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/employee")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		Employee newEmployee = service.saveEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList = service.getEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
		Employee employee = service.getEmployee(id).get();
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping("/employee")
	public ResponseEntity<?> update(@RequestBody Employee employee) {
		service.updateEmployee(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}