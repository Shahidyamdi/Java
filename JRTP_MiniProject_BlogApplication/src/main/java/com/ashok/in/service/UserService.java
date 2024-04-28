package com.ashok.in.service;

import com.ashok.in.binding.LoginForm;
import com.ashok.in.binding.RegistrationForm;

public interface UserService {
	public String login(LoginForm form);

	public boolean register(RegistrationForm form);

}
