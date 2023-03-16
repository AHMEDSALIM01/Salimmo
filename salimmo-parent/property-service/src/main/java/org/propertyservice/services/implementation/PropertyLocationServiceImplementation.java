package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.propertyservice.entities.PropertyLocation;
import org.propertyservice.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyLocationServiceImplementation implements BaseService<PropertyLocation> {
    @Override
    public PropertyLocation findById(Long id) {
        return null;
    }

    @Override
    public List<PropertyLocation> findAll() {
        return null;
    }

    @Override
    public Page<PropertyLocation> findAll(int page, int size) {
        return null;
    }

    @Override
    public PropertyLocation addOne(PropertyLocation propertyLocation) {
        return null;
    }

    @Override
    public List<PropertyLocation> multipleAdd(List<PropertyLocation> t) {
        return null;
    }

    @Override
    public PropertyLocation updateOne(PropertyLocation propertyLocation) {
        return null;
    }

    @Override
    public List<PropertyLocation> multipleUpdate(List<PropertyLocation> t) {
        return null;
    }
}
