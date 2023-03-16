package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.propertyservice.entities.PropertyOwner;
import org.propertyservice.services.PropertyOwnerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyOwnerServiceImplementation implements PropertyOwnerService {
    @Override
    public PropertyOwner findById(Long id) {
        return null;
    }

    @Override
    public List<PropertyOwner> findAll() {
        return null;
    }

    @Override
    public Page<PropertyOwner> findAll(int page, int size) {
        return null;
    }

    @Override
    public PropertyOwner addOne(PropertyOwner propertyOwner) {
        return null;
    }

    @Override
    public List<PropertyOwner> multipleAdd(List<PropertyOwner> owners) {
        return null;
    }

    @Override
    public PropertyOwner updateOne(PropertyOwner propertyOwner) {
        return null;
    }

    @Override
    public List<PropertyOwner> multipleUpdate(List<PropertyOwner> owners) {
        return null;
    }

    @Override
    public PropertyOwner deleteOneById(Long id) {
        return null;
    }

    @Override
    public List<PropertyOwner> deleteByMultipleId(List<Long> ids) {
        return null;
    }
}
