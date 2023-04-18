package com.ashok.in.binding;

import lombok.Data;

@Data
public class UnlockForm {
	private String temporaryPwd;
	private String newPwd;
	private String confirmPwd;

}
