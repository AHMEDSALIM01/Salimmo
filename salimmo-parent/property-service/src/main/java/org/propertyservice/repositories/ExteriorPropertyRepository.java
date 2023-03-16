package org.propertyservice.repositories;

import org.propertyservice.entities.ExteriorProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExteriorPropertyRepository extends JpaRepository<ExteriorProperty,Long> {
}
