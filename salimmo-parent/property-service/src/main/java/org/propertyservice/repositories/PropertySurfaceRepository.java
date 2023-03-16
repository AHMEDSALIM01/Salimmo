package org.propertyservice.repositories;

import org.propertyservice.entities.PropertySurface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertySurfaceRepository extends JpaRepository<PropertySurface,Long> {
}
