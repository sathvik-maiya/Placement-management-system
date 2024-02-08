package org.tnsif.placementmanagement.controller;

import java.util.NoSuchElementException;
import java.util.List;

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
import org.tnsif.placementmanagement.entities.Placement;
import org.tnsif.placementmanagement.entities.Student;
import org.tnsif.placementmanagement.services.PlacementService;

@RestController
public class PlacementController 
{

	@Autowired
	private PlacementService service;
	
	//RESTful API for CRUD operation
	@GetMapping("/placements")
	public List<Placement> listall(){
		return service.retrivAll();
	}
	
	//add placement
	@PostMapping("/placements")
	public void save(@RequestBody Placement placement)
	{
		service.savePlacement(placement);
	}
	
	//update placement
	@PutMapping("/placements/{id}")
	public ResponseEntity<?> update(@RequestBody Placement newPlacement, @PathVariable Integer id) {
	    try {
	        Placement existingPlacement = service.getPlacement(id);
	        
	        if (existingPlacement != null) {
	            // Update the fields of the existingPlacement with new values
	            existingPlacement.setName(newPlacement.getName());
	            existingPlacement.setDate(newPlacement.getDate());
	            existingPlacement.setQualification(newPlacement.getQualification());
	            existingPlacement.setYear(newPlacement.getYear());
	            
	            // Save the updated placement
	            service.savePlacement(existingPlacement);
	            
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


	//cancel/delete placement
	@DeleteMapping("/placements/{id}")
	public void delete(@PathVariable Integer id)
	{
		service.deletePlacement(id);
	}
	
	//search/find placement
	@GetMapping("/placements/{id}")
	public ResponseEntity<Placement> get(@PathVariable Integer id)
	{
		try {
			Placement placement = service.getPlacement(id);
			return new ResponseEntity<Placement>(placement, HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
		
	
	
}