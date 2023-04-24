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
@Table(name = "AIT_ENQURIRY_STATUS")
public class EnqStatusEntity {

	@Id

	private Integer statusid;
	private String statusName;

}
