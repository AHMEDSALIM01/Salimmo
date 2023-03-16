package org.propertyservice.repositories;

import org.propertyservice.entities.InnerProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerPropertyRepository extends JpaRepository<InnerProperty,Long> {
}
