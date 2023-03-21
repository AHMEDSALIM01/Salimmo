package org.propertyservice.services;

import org.propertyservice.dto.ExteriorPropertyDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ExteriorPropertyService {
    ExteriorPropertyDto findById(Long id);
    Page<ExteriorPropertyDto> findAll(int page, int size);
    ExteriorPropertyDto add(ExteriorPropertyDto exteriorPropertyDto);
    ExteriorPropertyDto update(Long id, ExteriorPropertyDto exteriorPropertyDto);
}
