package com.rafael.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.workshop.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{


}
