package org.propertyservice.services;

import org.propertyservice.dto.PropertyOwnerDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PropertyOwnerService{
    PropertyOwnerDto findById(Long id);
    Page<PropertyOwnerDto> findAll(int page, int size);

    List<PropertyOwnerDto> findAll();

    PropertyOwnerDto add(PropertyOwnerDto propertyDto);
    PropertyOwnerDto update(Long id, PropertyOwnerDto propertyDto);
    String deleteOneById(Long id);
    Map<String,String> deleteMultipleById(List<Long> ids);
}
