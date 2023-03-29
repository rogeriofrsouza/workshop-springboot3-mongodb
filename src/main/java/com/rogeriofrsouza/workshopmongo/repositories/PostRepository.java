package com.rogeriofrsouza.workshopmongo.repositories;

import java.time.Instant;
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
	
	// "Buscar posts contendo um dado string em qualquer lugar e em um dado intervalo de datas"
	
	@Query("{ $and: [ "
			+ "{ moment: { $gte: ?1 } }, "
			+ "{ moment: { $lte: ?2 } }, "
			+ "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Instant minDate, Instant maxDate);
}
