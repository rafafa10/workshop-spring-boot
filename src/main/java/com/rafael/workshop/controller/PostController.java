package com.rafael.workshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.workshop.controller.util.URL;
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
	
	@GetMapping(value="/title")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
	    text = URL.decodeParam(text);
	    List<Post> list = postService.findByTitle(text);
	    return ResponseEntity.ok().body(list);
	}
	
}
