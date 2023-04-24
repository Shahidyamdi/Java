package com.ashok.in.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AIT_STUDENT_ENQURIES")
public class StudentEnqEntity {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enqId; // PK AUTO_INCREMENT
	private String studentName;
	private long phno;
	private String classMode;

	private String courseName;
	private String enqStatus;
	@CreationTimestamp
	private LocalDate dateCreated;
	@UpdateTimestamp
	private LocalDate dateUpdated;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserDtlsEntity user;

}
