package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.PropertyEnergiesDto;
import org.propertyservice.entities.PropertyEnergies;
import org.propertyservice.repositories.PropertyEnergiesRepository;
import org.propertyservice.services.PropertyEnergiesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PropertyEnergiesServiceImplementation implements PropertyEnergiesService {
    private final PropertyEnergiesRepository propertyEnergiesRepository;
    private final ModelMapper modelMapper;
    @Override
    public PropertyEnergiesDto findById(Long id) {
        Optional<PropertyEnergies> propertyEnergies = propertyEnergiesRepository.findById(id);
        return propertyEnergies.map(value -> modelMapper.map(value, PropertyEnergiesDto.class)).orElseThrow(() -> new NotFoundException("PropertyEnergies with id: "+id+" not found"));
    }

    @Override
    public Page<PropertyEnergiesDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<PropertyEnergies> propertyEnergiesPage = propertyEnergiesRepository.findAll(pageable);
        List<PropertyEnergiesDto> innerPropertyResponseDtoList = propertyEnergiesPage.getContent().stream().map(p->modelMapper.map(p, PropertyEnergiesDto.class)).collect(Collectors.toList());
        return new PageImpl<>(innerPropertyResponseDtoList, propertyEnergiesPage.getPageable(), propertyEnergiesPage.getTotalElements());
    }

    @Override
    public PropertyEnergiesDto add(PropertyEnergiesDto innerPropertyRequestDto) {
        PropertyEnergies propertyEnergies = modelMapper.map(innerPropertyRequestDto,PropertyEnergies.class);
        PropertyEnergies savedPropertyEnergies = propertyEnergiesRepository.save(propertyEnergies);
        return modelMapper.map(savedPropertyEnergies, PropertyEnergiesDto.class);
    }

    @Override
    public PropertyEnergiesDto update(Long id, PropertyEnergiesDto innerPropertyRequestDto) {
        PropertyEnergies propertyEnergies = propertyEnergiesRepository.findById(id).orElseThrow(()->new NotFoundException("PropertyEnergies with id "+id+" Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(innerPropertyRequestDto,propertyEnergies);
        PropertyEnergies updatedPropertyEnergies = propertyEnergiesRepository.save(propertyEnergies);
        return modelMapper.map(updatedPropertyEnergies, PropertyEnergiesDto.class);
    }
}
