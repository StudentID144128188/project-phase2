package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entity.UserModel;


public interface UserDao extends MongoRepository<UserModel, String>{
	
	UserModel findByUsername(String username);
	
}
