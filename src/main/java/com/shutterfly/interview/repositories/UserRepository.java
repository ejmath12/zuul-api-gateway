package com.shutterfly.interview.repositories;


import com.shutterfly.interview.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}