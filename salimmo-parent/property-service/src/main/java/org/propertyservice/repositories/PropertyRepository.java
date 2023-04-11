package org.propertyservice.repositories;

import org.propertyservice.entities.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
@Transactional
public interface PropertyRepository extends JpaRepository<Property,Long> {
    Page<Property> findAll(Pageable pageable);
    @Query(value = "SELECT * FROM property WHERE vues > 0 order by vues DESC LIMIT 10",nativeQuery = true)
    List<Property> findRecommended();
    Optional<Property> findPropertyByRef(UUID ref);
    @Override
    @Modifying
    @Query("update Property p set p.deleted = true, p.deletedAt = current_timestamp where p.id = :id")
    void deleteById(@Param("id") Long id);
}
