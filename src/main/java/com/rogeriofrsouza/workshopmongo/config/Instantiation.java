package com.rogeriofrsouza.workshopmongo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rogeriofrsouza.workshopmongo.domain.Post;
import com.rogeriofrsouza.workshopmongo.domain.User;
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
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Post p1 = new Post(null, LocalDate.parse("21/03/2018", fmt), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", u1);
		Post p2 = new Post(null, LocalDate.parse("21/03/2018", fmt), "Bom dia", "Hoje eu acordei feliz!", u1);
		
		// Instanciação (carga inicial) do banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		postRepository.saveAll(Arrays.asList(p1, p2));
	}

}
