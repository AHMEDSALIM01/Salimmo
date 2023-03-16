package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.propertyservice.entities.PropertySurface;
import org.propertyservice.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertySurfaceServiceImplementation implements BaseService<PropertySurface> {
    @Override
    public PropertySurface findById(Long id) {
        return null;
    }

    @Override
    public List<PropertySurface> findAll() {
        return null;
    }

    @Override
    public Page<PropertySurface> findAll(int page, int size) {
        return null;
    }

    @Override
    public PropertySurface addOne(PropertySurface propertySurface) {
        return null;
    }

    @Override
    public List<PropertySurface> multipleAdd(List<PropertySurface> t) {
        return null;
    }

    @Override
    public PropertySurface updateOne(PropertySurface propertySurface) {
        return null;
    }

    @Override
    public List<PropertySurface> multipleUpdate(List<PropertySurface> t) {
        return null;
    }
}
