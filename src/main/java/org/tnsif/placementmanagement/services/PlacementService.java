package org.tnsif.placementmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tnsif.placementmanagement.entities.Placement;
import org.tnsif.placementmanagement.entities.Student;
import org.tnsif.placementmanagement.repository.PlacementRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlacementService {

	@Autowired
	private PlacementRepository repo;
	
	//addition/insertion/creation
	public void savePlacement(Placement placement)
	{
		repo.save(placement);
	}
	
	//delete
	public void deletePlacement(Integer id)
	{
		repo.deleteById(id);
	}
	
	//search
	public Placement getPlacement(Integer id)
	{
	return repo.findById(id).get();
	}
	
	//update
	public Placement updatePlacement(Placement placement)
	{
		return repo.save(placement);
	}
	//update
	public List <Placement> retrivAll()
	{
		return repo.findAll();
	}
	
}
