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
import org.tnsif.placementmanagement.entities.Student;
import org.tnsif.placementmanagement.services.StudentService;
@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	//restful API for CRUD operation
	@GetMapping("/students")
	public List<Student> listall(){
		return service.retrivAll();
	}
	
	//retrieve with specific id
	@GetMapping("/students/{id}")
	public ResponseEntity<Student>get(@PathVariable Integer id) {
		try{
			Student student = service.retrieve(id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	
	// RESTful API method for Delete operation
	@DeleteMapping("/students/{id}")
	public void remove(@PathVariable Integer id) {
		service.delete(id);
	}
	
	//to insert data
	@PostMapping("/students")
	public void insert(@RequestBody Student student) {
		service.add(student);
	}
	
	//update data
	@PutMapping("/students/{id}")
	public ResponseEntity<?>update(@RequestBody Student student, @PathVariable Integer id){
		
		try{
			Student s1 = service.retrieve(id);
			service.add(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}