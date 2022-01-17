package com.rafael.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.workshop.model.Post;
import com.rafael.workshop.model.User;
import com.rafael.workshop.repository.PostRepository;
import com.rafael.workshop.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContaining(text);
	}
}
