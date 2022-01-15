package com.rafael.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafael.workshop.model.User;
import com.rafael.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... arg0) throws Exception {
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Borges", "maria@gmail.com");
		User alex = new User(null, "Alex Telles", "telles@gmail.com");
		User bob = new User(null, "Bob Alves", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
