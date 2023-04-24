package com.ashok.in.binding;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UnlockForm {
	private String email;
	private String temporaryPwd;
	private String newPwd;
	private String confirmPwd;

}
