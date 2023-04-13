package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.*;
import org.propertyservice.entities.*;
import org.propertyservice.enums.PropertyType;
import org.propertyservice.helpers.CriteriaFilter;
import org.propertyservice.repositories.PropertyRepository;
import org.propertyservice.services.*;
import org.propertyservice.validators.PropertyValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import javax.persistence.criteria.*;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PropertyServiceImplementation implements PropertyService {
    private final PropertyValidator propertyValidator;
    private final PropertyRepository propertyRepository;
    private final PropertyLocationService propertyLocationService;
    private final ExteriorPropertyService exteriorPropertyService;
    private final InnerPropertyService innerPropertyService;
    private final PropertyEnergiesService propertyEnergiesService;
    private final PropertyOwnerService propertyOwnerService;
    private final PropertySurfaceService propertySurfaceService;
    private final ModelMapper modelMapper;
    @Override
    public PropertyDto findById(Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        if(property.isPresent()){
            Property incrementVue = property.get();
            incrementVue.setVues(incrementVue.getVues()+1);
        }
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
    public Page<PropertyDto> filter(CriteriaFilter criteriaFilter,int page,int size){
        Pageable pageable = PageRequest.of(page,size);

        Page<Property> properties = propertyRepository.findAll(new Specification<Property>() {
            @Override
            public Predicate toPredicate(Root<Property> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(criteriaFilter.getCity() != null){
                    Join<Property,PropertyLocation> location= root.join("propertyLocation");
                    Join<PropertyLocation,City> city = location.join("city");
                    predicates.add(criteriaBuilder.like(city.get("name"),'%'+criteriaFilter.getCity()+'%'));
                }
                if(criteriaFilter.getMinPrice() !=null && criteriaFilter.getMaxPrice()!=null){
                    predicates.add(criteriaBuilder.between(root.get("netPrice"),criteriaFilter.getMinPrice(),criteriaFilter.getMinPrice()));
                }
                if(criteriaFilter.getNbrOfRooms()!=0){
                    Join<Property,InnerProperty> innerProperty = root.join("innerProperty");
                    predicates.add(criteriaBuilder.equal(innerProperty.get("nbrOfRooms"),criteriaFilter.getNbrOfRooms()));
                }
                if(criteriaFilter.getNbOfBath()!=0){
                    Join<Property,InnerProperty> innerProperty = root.join("innerProperty");
                    predicates.add(criteriaBuilder.equal(innerProperty.get("nbrOfBathrooms"),criteriaFilter.getNbOfBath()));
                }
                if(criteriaFilter.getType()!=null){
                    predicates.add(criteriaBuilder.equal(root.get("type"), PropertyType.valueOf(criteriaFilter.getType())));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        List<PropertyDto> propertyDtoList = properties.getContent().stream().map(p->modelMapper.map(p, PropertyDto.class)).collect(Collectors.toList());
        return new PageImpl<>(propertyDtoList, properties.getPageable(), properties.getTotalElements());
    }
    @Override
    public List<PropertyDto> findRecommended(){
        List<Property> properties = propertyRepository.findRecommended();
        return properties.stream().map(p->modelMapper.map(p,PropertyDto.class)).collect(Collectors.toList());
    }

    @Override
    public PropertyDto add(PropertyDto propertyDto) {
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
        if(property.getPropertyLocation().getId() == null){
            PropertyLocationDto propertyLocationDto = propertyLocationService.add(modelMapper.map(property.getPropertyLocation(),PropertyLocationDto.class));
            property.setPropertyLocation(modelMapper.map(propertyLocationDto,PropertyLocation.class));
        }
        Property savedProperty = propertyRepository.save(property);
        PropertyEnergies propertyEnergies = modelMapper.map(propertyEnergiesService.findById(property.getPropertyEnergies().getId()),PropertyEnergies.class);
        InnerProperty innerProperty = modelMapper.map(innerPropertyService.findById(property.getInnerProperty().getId()),InnerProperty.class);
        ExteriorProperty exteriorProperty = modelMapper.map(exteriorPropertyService.findById(property.getExteriorProperty().getId()),ExteriorProperty.class);
        PropertyOwner owner = modelMapper.map(propertyOwnerService.findById(property.getOwner().getId()),PropertyOwner.class);
        PropertySurface surface = modelMapper.map(propertySurfaceService.findById(property.getPropertySurface().getId()),PropertySurface.class);
        PropertyLocation location = modelMapper.map(propertyLocationService.findById(property.getPropertyLocation().getId()),PropertyLocation.class);
        propertyEnergies.setProperty(savedProperty);
        innerProperty.setProperty(savedProperty);
        exteriorProperty.setProperty(savedProperty);
        owner.setProperties(Set.of(savedProperty));
        surface.setProperty(savedProperty);
        location.setProperty(savedProperty);
        propertyEnergiesService.update(propertyEnergies.getId(),modelMapper.map(propertyEnergies, PropertyEnergiesDto.class));
        innerPropertyService.update(innerProperty.getId(),modelMapper.map(innerProperty, InnerPropertyDto.class));
        exteriorPropertyService.update(exteriorProperty.getId(),modelMapper.map(exteriorProperty, ExteriorPropertyDto.class));
        propertyOwnerService.update(owner.getId(),modelMapper.map(owner, PropertyOwnerDto.class));
        propertySurfaceService.update(surface.getId(),modelMapper.map(surface, PropertySurfaceDto.class));
        propertyLocationService.update(location.getId(),modelMapper.map(location,PropertyLocationDto.class));
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
    public PropertyDto deleteOneById(Long id) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if(optionalProperty.isEmpty()){
            throw new NotFoundException("Property with Id : "+id+" Not Found");
        }
        propertyRepository.deleteById(id);
        return modelMapper.map(optionalProperty,PropertyDto.class);
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
