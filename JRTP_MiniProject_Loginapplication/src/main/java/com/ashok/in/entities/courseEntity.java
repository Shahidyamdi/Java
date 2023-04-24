package com.ashok.in.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = " AIT_COURSES")
public class courseEntity {

	@Id
	private Integer courseid;
	private String courseName;

}
