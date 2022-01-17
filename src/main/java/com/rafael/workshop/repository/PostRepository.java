package com.rafael.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.workshop.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
