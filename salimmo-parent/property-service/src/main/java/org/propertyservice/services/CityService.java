package org.propertyservice.services;

import org.propertyservice.dto.CityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CityService {
    CityDto add(CityDto cityDto);
    CityDto update(Long id,CityDto cityDto);
    CityDto findById(Long id);
    Page<CityDto> findAll(int page, int size, Sort sort);

    List<CityDto> findAll();
}
