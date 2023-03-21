package org.propertyservice.services;

import org.propertyservice.dto.PropertyDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface PropertyService{
    PropertyDto findById(Long id);
    Page<PropertyDto> findAll(int page, int size);
    PropertyDto add(PropertyDto propertyDto);
    PropertyDto update(UUID ref, PropertyDto propertyDto);
    String deleteOneById(Long id);
    Map<String,String> deleteMultipleById(List<Long> ids);
}
