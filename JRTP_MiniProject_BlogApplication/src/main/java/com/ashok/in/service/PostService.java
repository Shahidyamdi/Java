package com.ashok.in.service;

import com.ashok.in.binding.PostForm;

public interface PostService {
	
	public boolean create(PostForm form);
	public boolean save(PostForm form);


}
