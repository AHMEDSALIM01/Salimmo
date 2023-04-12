package org.propertyservice.repositories;

import org.propertyservice.entities.InnerProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InnerPropertyRepository extends JpaRepository<InnerProperty,Long> {
    Page<InnerProperty> findAll(Pageable pageable);
    @Override
    List<InnerProperty> findAll();
}
