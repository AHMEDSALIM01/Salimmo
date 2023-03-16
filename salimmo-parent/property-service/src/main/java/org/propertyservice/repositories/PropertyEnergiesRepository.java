package org.propertyservice.repositories;

import org.propertyservice.entities.PropertyEnergies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyEnergiesRepository extends JpaRepository<PropertyEnergies,Long> {
}
