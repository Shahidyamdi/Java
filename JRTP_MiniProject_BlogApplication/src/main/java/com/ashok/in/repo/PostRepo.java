package com.ashok.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.in.entities.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
