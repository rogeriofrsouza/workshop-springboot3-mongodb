package com.rogeriofrsouza.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rogeriofrsouza.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
