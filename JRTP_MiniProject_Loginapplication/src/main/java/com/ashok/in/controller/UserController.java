package com.ashok.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashok.in.binding.LoginForm;
import com.ashok.in.binding.SignupForm;
import com.ashok.in.binding.UnlockForm;
import com.ashok.in.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String loginpage(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@PostMapping("/login")
	public String loginHandler(@ModelAttribute("loginForm") LoginForm loginform, Model model) {
		String status = userService.login(loginform);
		if (status.contains("success")) {
			return "redirect:/dashboard";

		}

		model.addAttribute("errmsg", status);
		return "login";
	}

	@GetMapping("/signup")
	public String signuppage(Model model) {
		model.addAttribute("user", new SignupForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String handlesignup(@ModelAttribute("user") SignupForm form, Model model) {
		boolean status = userService.signup(form);
		if (status) {
			model.addAttribute("Success", "Account Created ! check Your Mail");
		} else {
			model.addAttribute("errmsg", " choose Unique Mail");

		}
		return "signup";

	}

	@GetMapping("/forgotPwd")
	public String forgotpwdpage() {
		return "forgotPwd";
	}

	@PostMapping("/forgotPwd")
	public String forgotpwdhandler(@RequestParam("email") String email, Model model) {
		System.out.println(email);

		boolean status = userService.forgotpwd(email);
		if (status) {
			model.addAttribute("success", "Pwd sent to your email");
		} else {

			model.addAttribute("errmsg", "Invaild Email");
		}
		return "forgotPwd";
	}

	@GetMapping("/unlock")
	public String getUnlock(@RequestParam String email, Model model) {
		System.out.println("-----------unlock----------email== " + email);
		UnlockForm unlockFrm = new UnlockForm();
		unlockFrm.setEmail(email);

		model.addAttribute("unlockFrm", unlockFrm);

		return "unlock";
	}

	@PostMapping("/unlock")
	public String unlockAccount(@ModelAttribute("unlockFrm") UnlockForm unlockFrm, Model model) {

		if (!unlockFrm.getNewPwd().equals(unlockFrm.getConfirmPwd())) {
			model.addAttribute("errMsg", "New Password and Confirm Password must be same.");
			System.out.println("-----------not equals---------- ");
		} else {
			System.out.println("-----------equals---------- ");
			boolean sUnlockStatus = userService.unlock(unlockFrm);
			System.out.println("-----------sUnlockStatus---------- " + sUnlockStatus);
			if (sUnlockStatus) {
				model.addAttribute("succMsg", "Your Account Unlocked Successfully.");
			} else {
				model.addAttribute("errMsg", "Invalid Temporary Password. Please check mail.");
			}

		}

		model.addAttribute("unlockFrm", unlockFrm);

		return "unlock";
	}

}
