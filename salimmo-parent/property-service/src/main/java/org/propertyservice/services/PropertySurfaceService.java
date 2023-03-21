package org.propertyservice.services;

import org.propertyservice.dto.PropertySurfaceDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface PropertySurfaceService {
    PropertySurfaceDto findById(Long id);
    Page<PropertySurfaceDto> findAll(int page, int size);
    PropertySurfaceDto add(PropertySurfaceDto propertySurfaceDto);
    PropertySurfaceDto update(Long id, PropertySurfaceDto propertySurfaceDto);
}
