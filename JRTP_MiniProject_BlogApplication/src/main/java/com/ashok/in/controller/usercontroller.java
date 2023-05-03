package com.ashok.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ashok.in.service.UserService;

@Controller
public class usercontroller {
	@Autowired
	UserService userservice;

}
