package com.ashok.in.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.in.binding.PostForm;
import com.ashok.in.entities.Post;
import com.ashok.in.repo.PostRepo;
@Service
public class PostServiceImp implements PostService {
@Autowired
PostRepo postrepo;
	@Override
	public boolean create(PostForm form) {
		Post entity = new Post();
		BeanUtils.copyProperties(form, entity);
		entity.setTitle(form.getTitle());
		entity.setDescripition(form.getDescripition());
		entity.setContent(form.getContent());
		postrepo.save(entity);
		
		return true ;
	}
	@Override
	public boolean save(PostForm form) {
		postrepo.findAll();
		return true;
	}

}
