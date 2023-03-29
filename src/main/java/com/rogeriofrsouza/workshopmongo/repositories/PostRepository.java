package com.rogeriofrsouza.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rogeriofrsouza.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	/*
	 * Query methods - Spring Data
	 * Busca posts contendo um dado string no título, ignora case sensitive
	 */
	List<Post> findByTitleContainingIgnoreCase(String text);
}
