package com.ashok.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.in.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
