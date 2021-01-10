package com.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bank.model.User;

//CRUD operation could be used if you extend CrudRepositery, provide your username and data type
public interface UserRepo extends CrudRepository<User, Long> {
	//findby is like where condition.
	Optional<User> findByUsername(String username);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	List<User> findAll();

}
