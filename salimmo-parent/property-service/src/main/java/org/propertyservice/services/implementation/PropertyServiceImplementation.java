package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.*;
import org.propertyservice.entities.*;
import org.propertyservice.repositories.PropertyRepository;
import org.propertyservice.services.*;
import org.propertyservice.validators.PropertyValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyServiceImplementation implements PropertyService {
    private final PropertyValidator propertyValidator;
    private final PropertyRepository propertyRepository;
   // private final PropertyLocationService
    private final ExteriorPropertyService exteriorPropertyService;
    private final InnerPropertyService innerPropertyService;
    private final PropertyEnergiesService propertyEnergiesService;
    private final PropertyOwnerService propertyOwnerService;
    private final PropertySurfaceService propertySurfaceService;
    private final ModelMapper modelMapper;
    @Override
    public PropertyDto findById(Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        return property.map(value -> modelMapper.map(value, PropertyDto.class)).orElseThrow(() -> new NotFoundException("property not found"));
    }

    @Override
    public Page<PropertyDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Property> properties = propertyRepository.findAll(pageable);
        List<PropertyDto> propertyDtoList = properties.getContent().stream().map(p->modelMapper.map(p, PropertyDto.class)).collect(Collectors.toList());
        return new PageImpl<>(propertyDtoList, properties.getPageable(), properties.getTotalElements());
    }

    @Override
    public PropertyDto add(PropertyDto propertyDto, MultipartFile [] files) {
        if(Boolean.FALSE.equals(propertyValidator.isValid(propertyDto))){
            throw new IllegalStateException(propertyValidator.getMessage());
        }
        Property property = modelMapper.map(propertyDto,Property.class);
        if(property.getPropertyEnergies().getId() == null){
            PropertyEnergiesDto propertyEnergiesDto = propertyEnergiesService.add(modelMapper.map(property.getPropertyEnergies(),PropertyEnergiesDto.class));
            property.setPropertyEnergies(modelMapper.map(propertyEnergiesDto,PropertyEnergies.class));
        }
        if(property.getExteriorProperty().getId()==null){
            ExteriorPropertyDto exteriorPropertyDto = exteriorPropertyService.add(modelMapper.map(property.getExteriorProperty(),ExteriorPropertyDto.class));
            property.setExteriorProperty(modelMapper.map(exteriorPropertyDto,ExteriorProperty.class));
        }
        if(property.getInnerProperty().getId()==null){
            InnerPropertyDto innerPropertyDto = innerPropertyService.add(modelMapper.map(property.getInnerProperty(),InnerPropertyDto.class));
            property.setInnerProperty(modelMapper.map(innerPropertyDto,InnerProperty.class));
        }
        if(property.getPropertySurface().getId()==null){
            PropertySurfaceDto propertySurfaceDto = propertySurfaceService.add(modelMapper.map(property.getPropertySurface(),PropertySurfaceDto.class));
            property.setPropertySurface(modelMapper.map(propertySurfaceDto,PropertySurface.class));
        }
        if(property.getOwner().getId() == null){
            PropertyOwnerDto propertyOwnerDto = propertyOwnerService.add(modelMapper.map(property.getOwner(),PropertyOwnerDto.class));
            property.setOwner(modelMapper.map(propertyOwnerDto,PropertyOwner.class));
        }
        Property savedProperty = propertyRepository.save(property);
        PropertyEnergies propertyEnergies = modelMapper.map(propertyEnergiesService.findById(property.getPropertyEnergies().getId()),PropertyEnergies.class);
        InnerProperty innerProperty = modelMapper.map(innerPropertyService.findById(property.getInnerProperty().getId()),InnerProperty.class);
        ExteriorProperty exteriorProperty = modelMapper.map(exteriorPropertyService.findById(property.getExteriorProperty().getId()),ExteriorProperty.class);
        PropertyOwner owner = modelMapper.map(propertyOwnerService.findById(property.getOwner().getId()),PropertyOwner.class);
        PropertySurface surface = modelMapper.map(propertySurfaceService.findById(property.getPropertySurface().getId()),PropertySurface.class);
        propertyEnergies.setProperty(savedProperty);
        innerProperty.setProperty(savedProperty);
        exteriorProperty.setProperty(savedProperty);
        owner.setProperties(Set.of(savedProperty));
        surface.setProperty(savedProperty);
        propertyEnergiesService.update(propertyEnergies.getId(),modelMapper.map(propertyEnergies, PropertyEnergiesDto.class));
        innerPropertyService.update(innerProperty.getId(),modelMapper.map(innerProperty, InnerPropertyDto.class));
        exteriorPropertyService.update(exteriorProperty.getId(),modelMapper.map(exteriorProperty, ExteriorPropertyDto.class));
        propertyOwnerService.update(owner.getId(),modelMapper.map(owner, PropertyOwnerDto.class));
        propertySurfaceService.update(surface.getId(),modelMapper.map(surface, PropertySurfaceDto.class));
        return modelMapper.map(savedProperty, PropertyDto.class);
    }

    @Override
    public PropertyDto update(UUID ref, PropertyDto propertyDto) {
        Property property = propertyRepository.findPropertyByRef(ref).orElseThrow(()->new NotFoundException("Property with ref "+ref+" Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(propertyDto,property);
        Property updatedProperty = propertyRepository.save(property);
        return modelMapper.map(updatedProperty, PropertyDto.class);
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
