package com.rafael.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.workshop.domain.Usuario;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		
		Usuario maria = new Usuario("1", "Maria Borges", "maria@gmail.com");
		Usuario alex = new Usuario("2", "Alex Telles", "telles@gmail.com");
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
		
	}

}
