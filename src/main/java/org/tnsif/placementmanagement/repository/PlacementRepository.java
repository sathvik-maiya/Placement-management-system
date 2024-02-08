package org.tnsif.placementmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tnsif.placementmanagement.entities.Placement;

public interface PlacementRepository extends JpaRepository<Placement, Integer>{

}