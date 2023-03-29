package com.rogeriofrsouza.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rogeriofrsouza.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	/*
	 * Query methods - Spring Data
	 * Busca posts contendo um dado string no título, ignora case sensitive
	 */
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")  // ?0 -> valor recebido por parâmetro (text)
	List<Post> searchTitle(String text);
}
