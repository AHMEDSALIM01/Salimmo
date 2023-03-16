package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.propertyservice.entities.ExteriorProperty;
import org.propertyservice.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExteriorPropertyServiceImplementation implements BaseService<ExteriorProperty> {
    @Override
    public ExteriorProperty findById(Long id) {
        return null;
    }

    @Override
    public List<ExteriorProperty> findAll() {
        return null;
    }

    @Override
    public Page<ExteriorProperty> findAll(int page, int size) {
        return null;
    }

    @Override
    public ExteriorProperty addOne(ExteriorProperty exteriorProperty) {
        return null;
    }

    @Override
    public List<ExteriorProperty> multipleAdd(List<ExteriorProperty> exteriorPropertyList) {
        return null;
    }

    @Override
    public ExteriorProperty updateOne(ExteriorProperty exteriorProperty) {
        return null;
    }

    @Override
    public List<ExteriorProperty> multipleUpdate(List<ExteriorProperty> exteriorPropertyList) {
        return null;
    }
}
