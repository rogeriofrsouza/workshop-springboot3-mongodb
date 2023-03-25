package com.rogeriofrsouza.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogeriofrsouza.workshopmongo.domain.User;
import com.rogeriofrsouza.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		
		/*
		 *  Retorna a instância de um objeto sofisticado do Spring
		 *  Encapsula a estrutura necessária para retornar respostas HTTP com cabeçalhos, erros, etc
		 */
		return ResponseEntity.ok().body(list);
	}
}
