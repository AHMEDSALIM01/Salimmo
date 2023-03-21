package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.ExteriorPropertyDto;
import org.propertyservice.entities.ExteriorProperty;
import org.propertyservice.repositories.ExteriorPropertyRepository;
import org.propertyservice.services.ExteriorPropertyService;
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
public class ExteriorPropertyServiceImplementation implements ExteriorPropertyService {
    private final ExteriorPropertyRepository exteriorPropertyRepository;
    private final ModelMapper modelMapper;
    @Override
    public ExteriorPropertyDto findById(Long id) {
        Optional<ExteriorProperty> exteriorProperty = exteriorPropertyRepository.findById(id);
        return exteriorProperty.map(value -> modelMapper.map(value, ExteriorPropertyDto.class)).orElseThrow(() -> new NotFoundException("ExteriorProperty with id: "+id+" not found"));
    }

    @Override
    public Page<ExteriorPropertyDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<ExteriorProperty> exteriorProperties = exteriorPropertyRepository.findAll(pageable);
        List<ExteriorPropertyDto> exteriorPropertyDtoList = exteriorProperties.getContent().stream().map(p->modelMapper.map(p, ExteriorPropertyDto.class)).collect(Collectors.toList());
        return new PageImpl<>(exteriorPropertyDtoList, exteriorProperties.getPageable(), exteriorProperties.getTotalElements());
    }

    @Override
    public ExteriorPropertyDto add(ExteriorPropertyDto exteriorPropertyDto) {
        ExteriorProperty exteriorProperty = modelMapper.map(exteriorPropertyDto,ExteriorProperty.class);
        ExteriorProperty savedExteriorProperty = exteriorPropertyRepository.save(exteriorProperty);
        return modelMapper.map(savedExteriorProperty, ExteriorPropertyDto.class);
    }

    @Override
    public ExteriorPropertyDto update(Long id, ExteriorPropertyDto exteriorPropertyDto) {
        ExteriorProperty exteriorProperty = exteriorPropertyRepository.findById(id).orElseThrow(()->new NotFoundException("ExteriorProperty with id "+id+" Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(exteriorPropertyDto,exteriorProperty);
        ExteriorProperty updatedExteriorProperty = exteriorPropertyRepository.save(exteriorProperty);
        return modelMapper.map(updatedExteriorProperty, ExteriorPropertyDto.class);
    }
}
