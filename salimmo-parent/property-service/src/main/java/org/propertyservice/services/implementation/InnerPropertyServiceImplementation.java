package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.InnerPropertyDto;
import org.propertyservice.entities.InnerProperty;
import org.propertyservice.repositories.InnerPropertyRepository;
import org.propertyservice.services.InnerPropertyService;
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
public class InnerPropertyServiceImplementation implements InnerPropertyService {
    private final InnerPropertyRepository innerPropertyRepository;
    private final ModelMapper modelMapper;
    @Override
    public InnerPropertyDto findById(Long id) {
        Optional<InnerProperty> innerProperty = innerPropertyRepository.findById(id);
        return innerProperty.map(value -> modelMapper.map(value, InnerPropertyDto.class)).orElseThrow(() -> new NotFoundException("InnerProperty with id: "+id+" not found"));
    }

    @Override
    public Page<InnerPropertyDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<InnerProperty> innerProperties = innerPropertyRepository.findAll(pageable);
        List<InnerPropertyDto> innerPropertyDtoList = innerProperties.getContent().stream().map(p->modelMapper.map(p, InnerPropertyDto.class)).collect(Collectors.toList());
        return new PageImpl<>(innerPropertyDtoList, innerProperties.getPageable(), innerProperties.getTotalElements());
    }

    @Override
    public InnerPropertyDto add(InnerPropertyDto innerPropertyDto) {
        InnerProperty innerProperty = modelMapper.map(innerPropertyDto,InnerProperty.class);
        InnerProperty savedInnerProperty = innerPropertyRepository.save(innerProperty);
        return modelMapper.map(savedInnerProperty, InnerPropertyDto.class);
    }

    @Override
    public InnerPropertyDto update(Long id, InnerPropertyDto innerPropertyDto) {
        InnerProperty innerProperty = innerPropertyRepository.findById(id).orElseThrow(()->new NotFoundException("InnerProperty with id "+id+" Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(innerPropertyDto,innerProperty);
        InnerProperty updatedInnerProperty = innerPropertyRepository.save(innerProperty);
        return modelMapper.map(updatedInnerProperty, InnerPropertyDto.class);
    }
}
