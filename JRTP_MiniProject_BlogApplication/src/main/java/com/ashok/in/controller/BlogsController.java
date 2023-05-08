package com.ashok.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashok.in.binding.AddBlogRequestModel;
import com.ashok.in.binding.BlogsDataResp;
import com.ashok.in.service.BlogsServices;
import com.ashok.in.utils.AppUtils;

@Controller
public class BlogsController {
	@Autowired
	BlogsServices  blogsservice;

	
	@GetMapping(value = "/addblog")
	public String addPost(@RequestParam(name = "id", required = false) String blogId, Model model) {
		BlogsDataResp blogByBlogId = new BlogsDataResp();
		if (blogId != null) {
			blogByBlogId = blogsservice.getBlogsByBlogId(Integer.valueOf(blogId));
		}
		model.addAttribute("add_blog_req", blogByBlogId);
		return AppUtils.ADD_BLOG;
	}
	@GetMapping(value = "/user-index")
	public String userIndexLoad(Model model) {
		List<BlogsDataResp> blogsByUserId = blogsservice.getBlogsByUserId();
		//System.out.println(blogsByUserId);
		model.addAttribute("my_blog_list", blogsByUserId);
		return AppUtils.USER_INDEX;
	}

	@PostMapping(value = "/addblog")
	public String addBlog(AddBlogRequestModel addBlogReq, Model model) {
		System.out.println(addBlogReq);
		String addBlog = blogsservice.addBlog(addBlogReq);
		System.out.println(addBlog);
		return "redirect:" + AppUtils.USER_INDEX;
	}
}
