package org.propertyservice.services;

import org.propertyservice.dto.requestsdto.PropertyRequestDto;
import org.propertyservice.dto.responsedto.PropertyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface PropertyService{
    PropertyResponseDto findById(Long id);
    List<PropertyResponseDto> findAll();
    Page<PropertyResponseDto> findAll(int page, int size);
    PropertyResponseDto add(PropertyRequestDto propertyRequestDto);
    PropertyResponseDto update(UUID id, PropertyRequestDto propertyRequestDto);
    String deleteOneById(Long id);
    Map<String,String> deleteMultipleById(List<Long> ids);
}
