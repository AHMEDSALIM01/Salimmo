package org.propertyservice.services;

import org.propertyservice.dto.PropertyLocationDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PropertyLocationService {
    Page<PropertyLocationDto> findAll(int page, int size);

    List<PropertyLocationDto> findAll();

    PropertyLocationDto findById(Long id);
    PropertyLocationDto add(PropertyLocationDto propertyLocationDto);
    PropertyLocationDto update(Long id,PropertyLocationDto propertyLocationDto);
}
