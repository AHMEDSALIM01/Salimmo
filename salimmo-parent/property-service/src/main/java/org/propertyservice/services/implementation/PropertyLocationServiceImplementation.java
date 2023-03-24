package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.PropertyLocationDto;
import org.propertyservice.entities.PropertyLocation;
import org.propertyservice.repositories.PropertyLocationRepository;
import org.propertyservice.services.PropertyLocationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyLocationServiceImplementation implements PropertyLocationService {
    private final PropertyLocationRepository propertyLocationRepository;
    private final ModelMapper modelMapper;
    @Override
    public Page<PropertyLocationDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<PropertyLocation> propertyLocations = propertyLocationRepository.findAll(pageable);
        List<PropertyLocationDto> propertyLocationDtoList = propertyLocations.getContent().stream().map(pl->modelMapper.map(pl,PropertyLocationDto.class)).collect(Collectors.toList());
        return new PageImpl<>(propertyLocationDtoList,propertyLocations.getPageable(),propertyLocations.getTotalElements());
    }

    @Override
    public PropertyLocationDto findById(Long id) {
        Optional<PropertyLocation> propertyLocation = propertyLocationRepository.findById(id);
        return propertyLocation.map(value -> modelMapper.map(value, PropertyLocationDto.class)).orElseThrow(() -> new NotFoundException("property not found"));
    }

    @Override
    public PropertyLocationDto add(PropertyLocationDto propertyLocationDto) {
        PropertyLocation propertyLocation = modelMapper.map(propertyLocationDto,PropertyLocation.class);
        PropertyLocation savedLocation = propertyLocationRepository.save(propertyLocation);
        return modelMapper.map(savedLocation,PropertyLocationDto.class);
    }

    @Override
    public PropertyLocationDto update(Long id,PropertyLocationDto propertyLocationDto) {
        PropertyLocation propertyLocation = propertyLocationRepository.findById(id).orElseThrow(()->new NotFoundException("Location with id : "+id+" Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(propertyLocationDto,propertyLocation);
        PropertyLocation updatedProperty = propertyLocationRepository.save(propertyLocation);
        return modelMapper.map(updatedProperty, PropertyLocationDto.class);
    }
}