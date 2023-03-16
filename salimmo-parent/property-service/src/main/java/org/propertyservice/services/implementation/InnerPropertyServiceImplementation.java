package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.propertyservice.entities.InnerProperty;
import org.propertyservice.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InnerPropertyServiceImplementation implements BaseService<InnerProperty> {
    @Override
    public InnerProperty findById(Long id) {
        return null;
    }

    @Override
    public List<InnerProperty> findAll() {
        return null;
    }

    @Override
    public Page<InnerProperty> findAll(int page, int size) {
        return null;
    }

    @Override
    public InnerProperty addOne(InnerProperty innerProperty) {
        return null;
    }

    @Override
    public List<InnerProperty> multipleAdd(List<InnerProperty> t) {
        return null;
    }

    @Override
    public InnerProperty updateOne(InnerProperty innerProperty) {
        return null;
    }

    @Override
    public List<InnerProperty> multipleUpdate(List<InnerProperty> t) {
        return null;
    }
}
