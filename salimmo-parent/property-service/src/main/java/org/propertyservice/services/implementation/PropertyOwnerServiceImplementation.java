package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.propertyservice.dto.PropertyOwnerDto;
import org.propertyservice.entities.PropertyOwner;
import org.propertyservice.repositories.PropertyOwnerRepository;
import org.propertyservice.services.PropertyOwnerService;
import org.propertyservice.validators.OwnerValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PropertyOwnerServiceImplementation implements PropertyOwnerService {
    private final PropertyOwnerRepository propertyOwnerRepository;
    private final OwnerValidator ownerValidator;
    private final ModelMapper modelMapper;
    @Override
    public PropertyOwnerDto findById(Long id) {
        Optional<PropertyOwner> owner = propertyOwnerRepository.findById(id);
        return owner.map(value -> modelMapper.map(value, PropertyOwnerDto.class)).orElseThrow(() -> new NotFoundException("owner with id "+id+" not found"));
    }

    @Override
    public Page<PropertyOwnerDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<PropertyOwner> owners = propertyOwnerRepository.findAll(pageable);
        List<PropertyOwnerDto> propertyResponseDtoList = owners.getContent().stream().map(p->modelMapper.map(p, PropertyOwnerDto.class)).collect(Collectors.toList());
        return new PageImpl<>(propertyResponseDtoList, owners.getPageable(), owners.getTotalElements());
    }

    @Override
    public PropertyOwnerDto add(PropertyOwnerDto propertyOwnerRequestDto) {
        if(Boolean.FALSE.equals(ownerValidator.isValid(propertyOwnerRequestDto))){
            throw new IllegalStateException(ownerValidator.getMessage());
        }
        PropertyOwner owner = modelMapper.map(propertyOwnerRequestDto,PropertyOwner.class);
        PropertyOwner savedOwner = propertyOwnerRepository.save(owner);
        return modelMapper.map(savedOwner, PropertyOwnerDto.class);
    }

    @Override
    public PropertyOwnerDto update(Long id, PropertyOwnerDto propertyOwnerRequestDto) {
        PropertyOwner owner = propertyOwnerRepository.findById(id).orElseThrow(()->new NotFoundException("Owner with id: "+id+" Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(propertyOwnerRequestDto,owner);
        PropertyOwner updatedProperty = propertyOwnerRepository.save(owner);
        return modelMapper.map(updatedProperty, PropertyOwnerDto.class);
    }

    @Override
    public String deleteOneById(Long id) {
        if(propertyOwnerRepository.findById(id).isEmpty()){
            throw new NotFoundException("Owner with Id : "+id+" Not Found");
        }
        propertyOwnerRepository.deleteById(id);
        return "Owner deleted successfully";
    }

    @Override
    public Map<String,String> deleteMultipleById(List<Long> ids) {
        Map<String,String> deleteList = new HashMap<>();
        ids.forEach(id-> {
            if(propertyOwnerRepository.findById(id).isPresent()){
                propertyOwnerRepository.deleteById(id);
                deleteList.put("Owner with id "+id+" deleted successfully","OK");
            }else{
                deleteList.put("Owner with id "+id+" Not found","NOT_FOUND");
            }
        });
        return deleteList;
    }
}
