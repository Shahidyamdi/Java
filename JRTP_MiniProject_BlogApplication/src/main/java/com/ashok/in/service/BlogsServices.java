package com.ashok.in.service;

import java.util.List;

import com.ashok.in.binding.AddBlogRequestModel;
import com.ashok.in.binding.BlogsDataResp;

public interface BlogsServices {
	public String addBlog(AddBlogRequestModel addBlogRequest);

	public BlogsDataResp getBlogsByBlogId(Integer blogId);

	public List<BlogsDataResp> getBlogsByUserId();
}
