package com.ashok.in.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name=" AIT_COURSES")
public class courseEntity {
	
	  @Id
	  private Integer courseid;
	 private String courseName;
	 
}
