package org.propertyservice.repositories;

import org.propertyservice.entities.PropertyEnergies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyEnergiesRepository extends JpaRepository<PropertyEnergies,Long> {
    Page<PropertyEnergies> findAll(Pageable pageable);

    @Override
    List<PropertyEnergies> findAll();
}
