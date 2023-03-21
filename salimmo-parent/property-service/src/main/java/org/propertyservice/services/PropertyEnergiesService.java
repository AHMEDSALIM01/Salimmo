package org.propertyservice.services;


import org.propertyservice.dto.PropertyEnergiesDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PropertyEnergiesService {
    PropertyEnergiesDto findById(Long id);
    Page<PropertyEnergiesDto> findAll(int page, int size);
    PropertyEnergiesDto add(PropertyEnergiesDto propertyEnergiesDto);
    PropertyEnergiesDto update(Long id, PropertyEnergiesDto propertyEnergiesDto);
}
