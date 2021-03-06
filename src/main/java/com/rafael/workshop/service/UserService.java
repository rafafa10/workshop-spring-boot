package com.rafael.workshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.workshop.DTO.UserDTO;
import com.rafael.workshop.model.User;
import com.rafael.workshop.repository.UserRepository;
import com.rafael.workshop.service.exception.ObjectNotFoundException;

@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User user) {
		Optional<User> newUser = userRepository.findById(user.getId());
		user.setName(newUser.get().getName());
		user.setName(newUser.get().getEmail());
		return userRepository.save(newUser.get());
	}
	
	
}
