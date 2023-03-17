package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.requestsdto.PropertyRequestDto;
import org.propertyservice.dto.responsedto.PropertyResponseDto;
import org.propertyservice.entities.Property;
import org.propertyservice.repositories.PropertyRepository;
import org.propertyservice.services.PropertyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyServiceImplementation implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final ModelMapper modelMapper;
    @Override
    public PropertyResponseDto findById(Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        return property.map(value -> modelMapper.map(value, PropertyResponseDto.class)).orElseThrow(() -> new NotFoundException("property not found"));
    }

    @Override
    public List<PropertyResponseDto> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Page<PropertyResponseDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Property> properties = propertyRepository.findAll(pageable);
        List<PropertyResponseDto> propertyResponseDtoList = properties.getContent().stream().map(p->modelMapper.map(p,PropertyResponseDto.class)).collect(Collectors.toList());
        return new PageImpl<>(propertyResponseDtoList, properties.getPageable(), properties.getTotalElements());
    }

    @Override
    public PropertyResponseDto add(PropertyRequestDto propertyRequestDto) {
        Property property = modelMapper.map(propertyRequestDto,Property.class);
        Property savedProperty = propertyRepository.save(property);
        return modelMapper.map(savedProperty,PropertyResponseDto.class);
    }
    
    @Override
    public PropertyResponseDto update(UUID ref, PropertyRequestDto propertyRequestDto) {
        if(propertyRepository.findPropertyByRef(ref).isEmpty()){
            throw new NotFoundException("Property with ref :"+ref+" Not Found");
        }
        Property property = propertyRepository.findPropertyByRef(ref).orElseThrow(()->new NotFoundException("Property Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(propertyRequestDto,property);
        Property updatedProperty = propertyRepository.save(property);
        return modelMapper.map(updatedProperty,PropertyResponseDto.class);
    }

    @Override
    public String deleteOneById(Long id) {
        if(propertyRepository.findById(id).isEmpty()){
            throw new NotFoundException("Property with Id : "+id+" Not Found");
        }
        propertyRepository.deleteById(id);
        return "Property deleted successfully";
    }

    @Override
    public Map<String,String> deleteMultipleById(List<Long> ids) {
        Map<String,String> deleteTraitement = new HashMap<>();
        ids.forEach(id-> {
            if(propertyRepository.findById(id).isPresent()){
                propertyRepository.deleteById(id);
                deleteTraitement.put("Property with id "+id+" deleted successfully","OK");
            }else{
                deleteTraitement.put("Property with id "+id+" Not found","NOT_FOUND");
            }
        });
        return deleteTraitement;
    }
}
