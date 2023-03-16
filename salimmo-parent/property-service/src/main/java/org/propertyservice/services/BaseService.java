package org.propertyservice.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BaseService<T>{
    T findById(Long id);
    List<T> findAll();
    Page<T> findAll(int page,int size);
    T addOne(T t);
    List<T> multipleAdd(List<T> t);
    T updateOne(T t);
    List<T> multipleUpdate(List<T> t);
}
