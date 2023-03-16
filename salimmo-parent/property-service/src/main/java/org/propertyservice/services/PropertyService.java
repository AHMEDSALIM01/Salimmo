package org.propertyservice.services;

import org.propertyservice.entities.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService extends BaseService<Property>{
    Property deleteOneById(Long id);
    List<Property> deleteMultipleById(List<Long> ids);
}
