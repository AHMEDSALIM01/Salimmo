package org.propertyservice.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.propertyservice.entities.City;
import org.propertyservice.repositories.CityRepository;
import org.propertyservice.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityServiceImplementation implements BaseService<City> {
    private final CityRepository cityRepository;
    @Override
    public City findById(Long id) {
        return null;
    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public Page<City> findAll(int page, int size) {
        return null;
    }

    @Override
    public City addOne(City city) {
        return null;
    }

    @Override
    public List<City> multipleAdd(List<City> cities) {
        return null;
    }

    @Override
    public City updateOne(City city) {
        return null;
    }

    @Override
    public List<City> multipleUpdate(List<City> cities) {
        return null;
    }
}
