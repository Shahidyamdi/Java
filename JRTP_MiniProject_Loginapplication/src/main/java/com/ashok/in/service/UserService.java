package com.ashok.in.service;

import com.ashok.in.binding.LoginForm;
import com.ashok.in.binding.SignupForm;
import com.ashok.in.binding.UnlockForm;

public interface UserService {
	public String login(LoginForm form);
	public boolean signup(SignupForm form);
	public boolean emailCheck(String email);
	public String unlock(UnlockForm form);
	public String forgotpwd(String email);
	
	

}
