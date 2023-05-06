package com.ashok.in.binding;

import java.time.LocalDate;

import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class PostForm {
	private String title;
	private String descripition;
	@Lob
	private String content;
	@CreationTimestamp
	private LocalDate createdon;

}
