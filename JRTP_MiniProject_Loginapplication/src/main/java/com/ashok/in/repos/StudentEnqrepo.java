package com.ashok.in.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.in.entities.StudentEnqEntity;

public interface StudentEnqrepo extends JpaRepository<StudentEnqEntity, Integer> {

}
