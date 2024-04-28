package com.shahid.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shahid.model.profile;
@Repository
public interface profileRepository extends JpaRepository<profile,Integer>{ 

}
