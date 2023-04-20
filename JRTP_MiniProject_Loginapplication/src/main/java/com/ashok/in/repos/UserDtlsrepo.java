package com.ashok.in.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashok.in.entities.UserDtlsEntity;
@Repository
public interface UserDtlsrepo extends JpaRepository<UserDtlsEntity,Integer> {
	public UserDtlsEntity findByemail(String email);

}
