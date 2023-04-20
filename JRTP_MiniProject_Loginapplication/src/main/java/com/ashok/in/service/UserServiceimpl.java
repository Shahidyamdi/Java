package com.ashok.in.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.in.binding.LoginForm;
import com.ashok.in.binding.SignupForm;
import com.ashok.in.binding.UnlockForm;
import com.ashok.in.entities.UserDtlsEntity;
import com.ashok.in.repos.UserDtlsrepo;
import com.ashok.in.utility.EmailUtility;
import com.ashok.in.utility.PasswordUtility;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserDtlsrepo userDtlsrepo;
	@Autowired
	EmailUtility emailUtility;
	@Autowired
	PasswordUtility passwordUtility;

	@Override
	public String login(LoginForm form) {
		return null;
	}

	@Override
	public boolean signup(SignupForm form) {

		/*
		 * UserDtlsEntity user = userDtlsrepo.findByemail(form.getEmail()); if (user !=
		 * null) { return false; }
		 */

		UserDtlsEntity entity = new UserDtlsEntity();
		BeanUtils.copyProperties(form, entity);

		String temppwd = passwordUtility.generateRandomPwd();
		entity.setPwd(temppwd);

		entity.setAccStatus("locked");

		userDtlsrepo.save(entity);

		String to = form.getEmail();
		String subject = ("Unlock your Account ! Ashok IT");
		StringBuffer body = new StringBuffer();
		body.append("<h1> Use Below Temporary Password To Unlock Your Account</h1>");
		body.append("Temporary Pwd " + temppwd);

		emailUtility.sendEmail(to, subject, body.toString());

		return true;
	}

	@Override
	public boolean emailCheck(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String unlock(UnlockForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotpwd(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
