package org.propertyservice.services;

import org.propertyservice.dto.InnerPropertyDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface InnerPropertyService {
    InnerPropertyDto findById(Long id);
    Page<InnerPropertyDto> findAll(int page, int size);
    InnerPropertyDto add(InnerPropertyDto innerPropertyDto);
    InnerPropertyDto update(Long id, InnerPropertyDto innerPropertyDto);
}
