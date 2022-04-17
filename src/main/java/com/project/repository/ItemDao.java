package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entity.Item;

public interface ItemDao extends MongoRepository<Item, String>{

}
