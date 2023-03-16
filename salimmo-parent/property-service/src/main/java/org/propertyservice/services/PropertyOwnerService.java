package org.propertyservice.services;

import org.propertyservice.entities.PropertyOwner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyOwnerService extends BaseService<PropertyOwner>{
    PropertyOwner deleteOneById(Long id);
    List<PropertyOwner> deleteByMultipleId(List<Long> ids);
}
