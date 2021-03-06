package com.rafael.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafael.workshop.DTO.AuthorDTO;
import com.rafael.workshop.DTO.CommentDTO;
import com.rafael.workshop.model.Post;
import com.rafael.workshop.model.User;
import com.rafael.workshop.repository.PostRepository;
import com.rafael.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Borges", "maria@gmail.com");
		User alex = new User(null, "Alex Telles", "telles@gmail.com");
		User bob = new User(null, "Bob Alves", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("15/01/2022"), "Partiu viagem", "Vou ir rodar a Europa, Abraços!", new AuthorDTO(alex));
		Post post2 = new Post(null, sdf.parse("17/01/2022"), "Bom dia", "Hoje o dia está muito ensolarado!", new AuthorDTO(alex));
		
		CommentDTO c1 = new CommentDTO("Boa viagem, mano!", sdf.parse("16/01/2022"), new AuthorDTO(bob));
		CommentDTO c2 = new CommentDTO("Aproveita pra conhecer os museus!", sdf.parse("17/01/2022"), new AuthorDTO(maria));
		CommentDTO c3 = new CommentDTO("O dia está lindo mesmo!", sdf.parse("17/01/2022"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		alex.getPostList().addAll(Arrays.asList(post1, post2));
		userRepository.save(alex);
		
	}

}
