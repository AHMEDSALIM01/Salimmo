package org.propertyservice.repositories;

import org.propertyservice.entities.PropertyOwner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner,Long> {
    Page<PropertyOwner> findAll(Pageable pageable);

    @Override
    List<PropertyOwner> findAll();

    @Override
    @Modifying
    @Query("update PropertyOwner o set o.deleted = true, o.deletedAt = current_timestamp where o.id = :id")
    void deleteById(@Param("id") Long id);
}
