package org.tnsif.placementmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tnsif.placementmanagement.entities.College;
import org.tnsif.placementmanagement.repository.CollegeRepository;

import jakarta.transaction.Transactional;

@Service  //to hold
@Transactional
public class CollegeService {
	
	@Autowired
	private CollegeRepository reposi;
	
	//addition/creation/insertion
	public void add(College college)
	{
		reposi.save(college);
	}
	
	//Retrieve with specific id
	public College retrieve(Integer id)
	{
		return reposi.findById(id).get();
	}
	
	//delete
	public void delete(Integer id)
	{
		reposi.deleteById(id);
	}
	
	//to retrieve all the records
	public List<College>retreiveAll()
	{
		return reposi.findAll();
	}
}