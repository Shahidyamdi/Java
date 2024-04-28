package com.ashok.in.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.in.binding.AddBlogRequestModel;
import com.ashok.in.binding.BlogsDataResp;
import com.ashok.in.entities.Post;
import com.ashok.in.entities.User;
import com.ashok.in.repo.PostRepo;
import com.ashok.in.repo.UserRepo;
import com.ashok.in.utils.AppUtils;

@Service
public class BlogsServicesImpl implements BlogsServices {
	@Autowired
	UserRepo userrepo;
	@Autowired
	HttpSession session;
	@Autowired
	PostRepo postrepo;

	@Override
	public String addBlog(AddBlogRequestModel addBlogRequest) {
		Optional<User> userdata = userrepo.findById((Integer) session.getAttribute(AppUtils.USER_ID));
		Post postEntity = new Post();
		if (addBlogRequest.getBlogId() != null && addBlogRequest.getBlogId() != 0) {
			postEntity.setPostid(addBlogRequest.getBlogId());
		}
		postEntity.setContent(addBlogRequest.getContent());
		postEntity.setTitle(addBlogRequest.getTitle());
		postEntity.setDescripition(addBlogRequest.getShortDescription());
		postEntity.setUser(userdata.get());
		postrepo.save(postEntity);
		return AppUtils.POST_ADDED_SUCCESS;
	}

	@Override
	public BlogsDataResp getBlogsByBlogId(Integer blogId) {
		Optional<Post> blogPost = postrepo.findById(blogId);
		BlogsDataResp blogsDataResp = new BlogsDataResp();
		if (blogPost.isPresent()) {
			Post postEntity = blogPost.get();
			blogsDataResp.setBlogId(postEntity.getPostid());
			blogsDataResp.setContent(postEntity.getContent());
			blogsDataResp.setShortDescription(postEntity.getDescripition());
			blogsDataResp.setTitle(postEntity.getTitle());
		}
		return blogsDataResp;
	}

	@Override
	public List<BlogsDataResp> getBlogsByUserId() {
		// System.out.println((Integer) httpSession.getAttribute(AppUtils.USER_ID));
		Optional<User> userData = userrepo.findById((Integer) session.getAttribute(AppUtils.USER_ID));
		User userEntity = userData.get();
		List<Post> findByUser = postrepo.findByUserAndDeletedIsFalse(userEntity);
		List<BlogsDataResp> blogsDataResps = new ArrayList<>();
		if (findByUser != null && findByUser.size() > 0) {
			findByUser.forEach(currentUsersAllPost -> {
				BlogsDataResp data = new BlogsDataResp();
				data.setBlogId(currentUsersAllPost.getPostid());
				data.setContent(currentUsersAllPost.getContent());
				data.setTitle(currentUsersAllPost.getTitle());
				data.setShortDescription(currentUsersAllPost.getDescripition());
				data.setCreatedOn(currentUsersAllPost.getCreatedon().toString());
				blogsDataResps.add(data);
			});
		}
		return blogsDataResps;
	}
}
