package com.ashok.in.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.in.entities.courseEntity;

public interface courserepo  extends JpaRepository<courseEntity, Integer> {

}
