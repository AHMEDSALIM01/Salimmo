package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.CityDto;
import org.propertyservice.entities.City;
import org.propertyservice.repositories.CityRepository;
import org.propertyservice.services.CityService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityServiceImplementation implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Override
    public CityDto add(CityDto cityDto) {
        City city = modelMapper.map(cityDto,City.class);
        City savedCity = cityRepository.save(city);
        return modelMapper.map(savedCity,CityDto.class);
    }

    @Override
    public CityDto update(Long id, CityDto cityDto) {
        City city = cityRepository.findById(id).orElseThrow(()->new NotFoundException("City with id "+id+" Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(cityDto,city);
        City updatedCity = cityRepository.save(city);
        return modelMapper.map(updatedCity, CityDto.class);
    }

    @Override
    public CityDto findById(Long id) {
        City city = cityRepository.findById(id).orElseThrow(()->new NotFoundException("City with id "+id+" Not Found"));
        return modelMapper.map(city,CityDto.class);
    }

    @Override
    public Page<CityDto> findAll(int page, int size, Sort sort) {
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<City> cities = cityRepository.findAll(pageable);
        List<CityDto> cityDtoList  = cities.getContent().stream().map(c->modelMapper.map(c,CityDto.class)).collect(Collectors.toList());
        return new PageImpl<>(cityDtoList,cities.getPageable(),cities.getTotalElements());
    }

}
