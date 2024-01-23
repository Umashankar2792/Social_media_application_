package com.umashankar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umashankar.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
