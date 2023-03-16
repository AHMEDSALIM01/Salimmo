package org.propertyservice.repositories;

import org.propertyservice.entities.PropertyLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyLocationRepository extends JpaRepository<PropertyLocation,Long> {
}
