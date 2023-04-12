package org.propertyservice.services;

import org.propertyservice.dto.PropertySurfaceDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PropertySurfaceService {
    PropertySurfaceDto findById(Long id);
    Page<PropertySurfaceDto> findAll(int page, int size);

    List<PropertySurfaceDto> findAll();

    PropertySurfaceDto add(PropertySurfaceDto propertySurfaceDto);
    PropertySurfaceDto update(Long id, PropertySurfaceDto propertySurfaceDto);
}
