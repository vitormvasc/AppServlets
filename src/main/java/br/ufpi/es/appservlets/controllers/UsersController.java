package br.ufpi.es.appservlets.controllers;

import br.ufpi.es.appservlets.entities.*;

import java.util.List;

import br.ufpi.es.appservlets.data.*;

public class UsersController {
	IRepositoryUsers repository;
	
	public UsersController(IRepositoryUsers type){
		this.repository = type;
	}
	
	/**
	 * Returns all the users within a list of users
	 * @return list of users
	 */
	public List<User> getUsers(){
		return repository.list();
	}
	
	/**
	 * Given the user's credentials it checks if it exists
	 * @param login user's login
	 * @param password user's password
	 * @return user if a user exists / null if it does not
	 */
	public User search(String login, String password){
		return repository.search(login, password);
	}
	
	/**
	 * Searches an user by a given type
	 * @param given content of an user
	 * @param search by email, login or name
	 * @return list of users that match the credentials
	 */
	public List<User> searchByContentAndType(String content, String type){
		return repository.searchByContentAndType(content, type);
	}
	
	/**
	 * Inserts a new user onto the repository
	 * @param u credentials of a user
	 */
	public void insert(User u) {
		this.repository.insert(u);
	}
}
