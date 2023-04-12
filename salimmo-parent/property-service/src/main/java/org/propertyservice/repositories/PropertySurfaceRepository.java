package org.propertyservice.repositories;


import org.propertyservice.entities.PropertySurface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertySurfaceRepository extends JpaRepository<PropertySurface,Long> {
    Page<PropertySurface> findAll(Pageable pageable);

    @Override
    List<PropertySurface> findAll();
}
