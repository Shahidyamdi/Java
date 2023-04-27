package com.ashok.in.service;

import javax.servlet.http.HttpSession;

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
	@Autowired
	private HttpSession session;

	@Override
	public String login(LoginForm form) {
		UserDtlsEntity entity = userDtlsrepo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		if (entity == null) {
			return "Invalid Credentials";
		}
		if (entity.getAccStatus().equals("LOCKED")) {
			return "YOUR ACCOUNT LOCKED";
		}
		
		session.setAttribute("userId", entity.getUserId());
		return "success";
	}

	@Override
	public boolean signup(SignupForm form) {
		UserDtlsEntity user = userDtlsrepo.findByemail(form.getEmail());
		if (user != null) {
			return false;
		}

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
		body.append("<br/>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\">Click here to Unlock Account..</a>");
		emailUtility.sendEmail(to, subject, body.toString());

		return true;
	}

//	@Override
//	public String unlockAccount(UnlockForm form) {
//
//		UserDtlsEntity user = userRepo.findByEmail(form.getEmail());
//		
//		System.out.println(user);
//		
//		if(form.getTempPwd().equals(user.getPwd())) {
//			
//		if(form.getNewPwd().equals(form.getConfirmPwd())) {
//		
//			user.setPwd(form.getNewPwd());
//			user.setAccStatus("UNLOCKED");
//			
//			userRepo.save(user);
//			
//			System.out.println(user);
//			return "Account is Unlocked";
//		}else {
//			return "new password and Conform password not same";
//			
//		}
//		
//		}
//		else {
//			return "Temp password is incorrect ";
//		}
//			
//	}
//	

	// second way (sir way)
	@Override
	public boolean unlock(UnlockForm form) {

		UserDtlsEntity entity = userDtlsrepo.findByemail(form.getEmail());

		if (entity.getPwd().equals(form.getTemporaryPwd())) {
			entity.setPwd(form.getNewPwd());
			entity.setAccStatus("UNLOCKED");
			userDtlsrepo.save(entity);
			return true;
		} else {

			return false;
		}

	}

	@Override
	public boolean forgotpwd(String email) {
		UserDtlsEntity entity = userDtlsrepo.findByemail(email);
		if(entity==null) {
			return false;
		}
		
		String body ="Recover password";
		String subject =" Your Pwd :: " +entity.getPwd();
		
		emailUtility.sendEmail(email, body, subject);
		return true;
	}

}
