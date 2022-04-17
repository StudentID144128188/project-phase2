package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entity.Message;

public interface MessageDao extends MongoRepository<Message, String>{

}
