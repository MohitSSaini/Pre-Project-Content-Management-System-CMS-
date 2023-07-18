package com.example.Content.repository;

import com.example.Content.model.Userclass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Contentrepository extends MongoRepository<Userclass,String> {
}
