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
import org.tnsif.placementmanagement.entities.College;
import org.tnsif.placementmanagement.services.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	public CollegeService service;
	
	//RESTful API For CRUD Operation
	//to retrieve all the records
	@GetMapping("/college")
	public List<College>listAll()
	{
		return service.retreiveAll();
	}
	
	//retrieve with specific id
	@GetMapping("/college/{id}")
	public ResponseEntity<College> get(@PathVariable Integer id)
	{
		try
		{
			College college =service.retrieve(id);
			 return new ResponseEntity<College>(college, HttpStatus.OK);			
		}
		catch(NoSuchElementException e)
		{
			 return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete 
	@DeleteMapping("/college/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	
	//to insert a data
	@PostMapping("/college")
	public void insert(@RequestBody College college)
	{
		service.add(college);
	}
	
	//update a data
	@PutMapping("/college/{id}")
	public ResponseEntity<?>update(@RequestBody College college, @PathVariable Integer id)
	{
		try {
			College s1=service.retrieve(id);
			service.add(college);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
}