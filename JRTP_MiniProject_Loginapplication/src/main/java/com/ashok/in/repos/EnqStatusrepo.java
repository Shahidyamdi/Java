package com.ashok.in.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.in.entities.EnqStatusEntity;
import com.ashok.in.entities.StudentEnqEntity;

public interface EnqStatusrepo extends JpaRepository<EnqStatusEntity, Integer> {


}
