package org.tnsif.placementmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tnsif.placementmanagement.entities.College;

public interface CollegeRepository  extends JpaRepository<College,Integer>{

}