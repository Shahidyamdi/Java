package com.ashok.in.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ashok.in.binding.LoginForm;
import com.ashok.in.binding.RegistrationForm;
import com.ashok.in.entities.User;
import com.ashok.in.repo.UserRepo;

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userrepo;
	@Autowired
	HttpSession session;

	@Override
	public String login(LoginForm form) {
		User entity = userrepo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		if (entity == null) {
			return "Invalid Credentials";
		}

		session.setAttribute("userId", entity.getUserid());
		return "success";

	}

	@Override
	public boolean register(RegistrationForm form) {
		User user = userrepo.findByemail(form.getEmail());
		if (user != null) {
			return false;
		}
		User userentity = new User();
		BeanUtils.copyProperties(form, userentity);
		userentity.setEmail(form.getEmail());
		userentity.setEmail(form.getFname());
		userentity.setEmail(form.getLname());
		userentity.setEmail(form.getPwd());
		userrepo.save(userentity);

		return true;
	}

}
