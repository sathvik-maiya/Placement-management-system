package org.tnsif.placementmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tnsif.placementmanagement.entities.Student;
import org.tnsif.placementmanagement.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	//addition/creation/insertion
	public void add(Student student) {
		repo.save(student);
	}
	
	//retrieve with specific id
	public Student retrieve(Integer id) {
		return repo.findById(id).get();
	}
	
	//delete
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	//To retrieve all the records
	public List <Student> retrivAll(){
		return repo.findAll();
	}

}
