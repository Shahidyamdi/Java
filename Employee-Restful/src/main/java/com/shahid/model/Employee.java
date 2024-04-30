package com.shahid.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="emp")
public class Employee {
	@Id
	@GeneratedValue
	private Integer employeeId;
	private String employeeName;
	private Double employeeSalary;
	private String employeeEmail;
	private Long employeeMobile;

	public Employee() {
		super();
	}

	public Employee(Integer employeeId, String employeeName, Double employeeSalary, String employeeEmail,
			Long employeeMobile) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeEmail = employeeEmail;
		this.employeeMobile = employeeMobile;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public Long getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(Long employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", employeeEmail=" + employeeEmail + ", employeeMobile=" + employeeMobile + "]";
	}

	

}
