package org.tnsif.placementmanagement.controller;

import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tnsif.placementmanagement.entities.Admin;
import org.tnsif.placementmanagement.entities.Student;
import org.tnsif.placementmanagement.entities.User;
import org.tnsif.placementmanagement.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	//RESTful API for CRUD operation
	@GetMapping("/user")
	public List<User> listall(){
		return service.retrivAll();
	}
	
	//add User
	@PostMapping("/user")
	public void save(@RequestBody User user)
	{
		service.saveUser(user);
	}

	//update User
	@PutMapping("/user/{id}")
	public ResponseEntity<?>update(@RequestBody User user, @PathVariable Integer id)
	{
		try {
			User existUser = service.getUser(id);
			service.saveUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	//cancel/delete user
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.deleteUser(id);
	}
	
	
	//search/find user
	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id)
	{
		try {
				User user = service.getUser(id);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		catch(NoSuchElementException e)
		{
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
}