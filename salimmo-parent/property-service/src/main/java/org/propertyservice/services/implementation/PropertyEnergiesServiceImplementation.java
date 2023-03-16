package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.propertyservice.entities.PropertyEnergies;
import org.propertyservice.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyEnergiesServiceImplementation implements BaseService<PropertyEnergies> {
    @Override
    public PropertyEnergies findById(Long id) {
        return null;
    }

    @Override
    public List<PropertyEnergies> findAll() {
        return null;
    }

    @Override
    public Page<PropertyEnergies> findAll(int page, int size) {
        return null;
    }

    @Override
    public PropertyEnergies addOne(PropertyEnergies propertyEnergies) {
        return null;
    }

    @Override
    public List<PropertyEnergies> multipleAdd(List<PropertyEnergies> t) {
        return null;
    }

    @Override
    public PropertyEnergies updateOne(PropertyEnergies propertyEnergies) {
        return null;
    }

    @Override
    public List<PropertyEnergies> multipleUpdate(List<PropertyEnergies> t) {
        return null;
    }
}
