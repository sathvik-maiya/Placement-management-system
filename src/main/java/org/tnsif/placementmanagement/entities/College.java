package org.tnsif.placementmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="College")
public class College {

	@Id
	private Integer id;
	private String collegeName;
	private String location;
	
	//default constructor
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public College(Integer id, String collegeName, String location) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.location = location;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", location=" + location + "]";
	}

	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
}