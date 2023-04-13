package org.propertyservice.services;

import org.propertyservice.dto.PropertyDto;
import org.propertyservice.helpers.CriteriaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface PropertyService{
    PropertyDto findById(Long id);
    Page<PropertyDto> findAll(int page, int size);

    Page<PropertyDto> filter(CriteriaFilter criteriaFilter, int page,int size);

    List<PropertyDto> findRecommended();

    PropertyDto add(PropertyDto propertyDto);
    PropertyDto update(UUID ref, PropertyDto propertyDto);
    PropertyDto deleteOneById(Long id);
    Map<String,String> deleteMultipleById(List<Long> ids);
}
