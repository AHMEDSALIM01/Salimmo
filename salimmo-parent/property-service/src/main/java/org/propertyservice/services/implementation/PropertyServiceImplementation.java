package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.propertyservice.entities.Property;
import org.propertyservice.services.PropertyService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyServiceImplementation implements PropertyService {
    @Override
    public Property findById(Long id) {
        return null;
    }

    @Override
    public List<Property> findAll() {
        return null;
    }

    @Override
    public Page<Property> findAll(int page, int size) {
        return null;
    }

    @Override
    public Property addOne(Property property) {
        return null;
    }

    @Override
    public List<Property> multipleAdd(List<Property> properties) {
        return null;
    }

    @Override
    public Property updateOne(Property property) {
        return null;
    }

    @Override
    public List<Property> multipleUpdate(List<Property> properties) {
        return null;
    }

    @Override
    public Property deleteOneById(Long id) {
        return null;
    }

    @Override
    public List<Property> deleteMultipleById(List<Long> ids) {
        return null;
    }
}
