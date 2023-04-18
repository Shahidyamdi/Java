package com.ashok.in.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="AIT_ENQURIRY_STATUS")
public class EnqStatusEntity {

	@Id

	private Integer statusid;
	private String statusName;

}
