package org.tnsif.placementmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tnsif.placementmanagement.entities.Admin;
import org.tnsif.placementmanagement.repository.AdminRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminRepository repos;
	
	//add/create
	public void add(Admin admin)
	{
		repos.save(admin);
	}
	
	//Retrieve with specific id
	public Admin retrieve(Integer id)
	{
		return repos.findById(id).get();
	}
	
	//delete
	public void delete(Integer id)
	{
		repos.deleteById(id);
	}
	
	//to retrieve all the records
	public List<Admin>retreiveAll()
	{
		return repos.findAll();
	}
}