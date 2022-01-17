package com.rafael.workshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.workshop.model.Post;
import com.rafael.workshop.model.User;
import com.rafael.workshop.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
	    Post post = postService.findById(id);
	    return ResponseEntity.ok().body(post);
	}
	
}
