package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.PropertySurfaceDto;
import org.propertyservice.entities.PropertySurface;
import org.propertyservice.repositories.PropertySurfaceRepository;
import org.propertyservice.services.PropertySurfaceService;
import org.propertyservice.validators.SurfaceValidator;
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
public class PropertySurfaceServiceImplementation implements PropertySurfaceService {
    private final PropertySurfaceRepository propertySurfaceRepository;
    private final SurfaceValidator surfaceValidator;
    private final ModelMapper modelMapper;
    @Override
    public PropertySurfaceDto findById(Long id) {
        Optional<PropertySurface> propertySurface = propertySurfaceRepository.findById(id);
        return propertySurface.map(value -> modelMapper.map(value, PropertySurfaceDto.class)).orElseThrow(() -> new NotFoundException("PropertySurface with id :"+id+" not found"));
    }

    @Override
    public Page<PropertySurfaceDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<PropertySurface> propertiesSurface = propertySurfaceRepository.findAll(pageable);
        List<PropertySurfaceDto> propertySurfaceDtoList = propertiesSurface.getContent().stream().map(p->modelMapper.map(p, PropertySurfaceDto.class)).collect(Collectors.toList());
        return new PageImpl<>(propertySurfaceDtoList, propertiesSurface.getPageable(), propertiesSurface.getTotalElements());
    }

    @Override
    public List<PropertySurfaceDto> findAll() {
        List<PropertySurface> propertiesSurface = propertySurfaceRepository.findAll();
        return propertiesSurface.stream().map(p->modelMapper.map(p, PropertySurfaceDto.class)).collect(Collectors.toList());
    }

    @Override
    public PropertySurfaceDto add(PropertySurfaceDto propertySurfaceDto) {
        if(Boolean.FALSE.equals(surfaceValidator.isValid(propertySurfaceDto))){
            throw new IllegalStateException(surfaceValidator.getMessage());
        }
        PropertySurface propertySurface = modelMapper.map(propertySurfaceDto,PropertySurface.class);
        PropertySurface savedPropertySurface = propertySurfaceRepository.save(propertySurface);
        return modelMapper.map(savedPropertySurface, PropertySurfaceDto.class);
    }

    @Override
    public PropertySurfaceDto update(Long id, PropertySurfaceDto propertySurfaceDto) {
        PropertySurface propertySurface = propertySurfaceRepository.findById(id).orElseThrow(()->new NotFoundException("PropertySurface with id "+id+" Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(propertySurfaceDto,propertySurface);
        PropertySurface updatedPropertySurface = propertySurfaceRepository.save(propertySurface);
        return modelMapper.map(updatedPropertySurface, PropertySurfaceDto.class);
    }

}
