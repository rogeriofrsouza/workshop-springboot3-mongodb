package com.rogeriofrsouza.workshopmongo.dto;

import java.io.Serializable;

import com.rogeriofrsouza.workshopmongo.domain.User;

/*
 * Data Transfer Object: objeto com o papel de carregar dados das entidades de forma simples,
 * podendo "projetar" apenas alguns dados da entidade original. Vantagens:
 * - Otimiza o tráfego;
 * - Evita que dados de interesse exclusivo do sistema fiquem expostos;
 * - Customiza os objetos trafegados conforme a necessidade de cada requisição.
 */
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	public UserDTO() {
	}
	
	// Instancia um UserDTO a partir de um objeto User
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
