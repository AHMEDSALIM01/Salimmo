package org.propertyservice.repositories;

import org.propertyservice.entities.ExteriorProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExteriorPropertyRepository extends JpaRepository<ExteriorProperty,Long> {
    Page<ExteriorProperty> findAll(Pageable pageable);

    @Override
    List<ExteriorProperty> findAll();
}
