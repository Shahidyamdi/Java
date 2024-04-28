package com.ashok.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashok.in.entities.User;
@Repository
public interface UserRepo  extends JpaRepository<User, Integer>{
	public User findByemail(String email);
	public User findByEmailAndPwd(String email,String pwd);

}
