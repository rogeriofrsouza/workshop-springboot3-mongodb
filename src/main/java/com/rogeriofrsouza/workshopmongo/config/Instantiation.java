package com.rogeriofrsouza.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rogeriofrsouza.workshopmongo.domain.Post;
import com.rogeriofrsouza.workshopmongo.domain.User;
import com.rogeriofrsouza.workshopmongo.dto.AuthorDTO;
import com.rogeriofrsouza.workshopmongo.dto.CommentDTO;
import com.rogeriofrsouza.workshopmongo.repositories.PostRepository;
import com.rogeriofrsouza.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com", "123456");
		
		// Instanciação (carga inicial) do banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Post p1 = new Post(null, Instant.parse("2018-03-21T14:01:20Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
		Post p2 = new Post(null, Instant.parse("2018-04-15T16:38:55Z"), "Bom dia", "Hoje eu acordei feliz!", new AuthorDTO(u1));
		
		CommentDTO c1 = new CommentDTO("Boa viagem!", Instant.parse("2018-03-21T16:38:55Z"), new AuthorDTO(u2));
		CommentDTO c2 = new CommentDTO("Aproveite", Instant.parse("2018-03-23T06:25:09Z"), new AuthorDTO(u3));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", Instant.parse("2018-04-16T12:40:23Z"), new AuthorDTO(u2));
		
		// Associações de comentários em posts
		p1.getComments().addAll(Arrays.asList(c1, c2));
		p2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		// Incluindo posts do usuário
		u1.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(u1);
	}

}
