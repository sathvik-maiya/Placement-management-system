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
import org.tnsif.placementmanagement.entities.Placement;
import org.tnsif.placementmanagement.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;
	
	//RESTful API for CRUD operation
	@GetMapping("/admin")
	public List<Admin> listall(){
		return service.retreiveAll();
	}
	
	//add Admin
	@PostMapping("/admin")
	public void save(@RequestBody Admin admin)
	{
		service.add(admin);
	}
	
	//update placement

	
		@PutMapping("/admin/{id}")
		public ResponseEntity<?> update(@RequestBody Admin newAdmin, @PathVariable Integer id) {
		    try {
		        Admin existingAdmin = service.retrieve(id);

		        if (existingAdmin != null) {
		            // Update the fields of the existingAdmin with new values
		            existingAdmin.setName(newAdmin.getName());
		            existingAdmin.setPassword(newAdmin.getPassword());
		            // Repeat the above line for each field you want to update

		            // Save the updated admin
		            service.add(existingAdmin);

		            return new ResponseEntity<>(HttpStatus.OK);
		        } else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		    } catch (NoSuchElementException e) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		}

		//cancel/delete Admin
		@DeleteMapping("/admin/{id}")
		public void delete(@PathVariable Integer id)
		{
			service.delete(id);
		}
		
		//search/find admin
		@GetMapping("/admin/{id}")
		public ResponseEntity<Admin> get(@PathVariable Integer id)
		{
			try {
				Admin admin = service.retrieve(id);
				return new ResponseEntity<Admin>(admin, HttpStatus.OK);
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
			}
		}
}
