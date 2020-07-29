package ar.com.api.ada.nasa.nasa.services;

import java.util.List;

import org.bson.types.ObjectId;

import ar.com.api.ada.nasa.nasa.exceptions.ResourceNotFoundException;

public interface IEntityCRUDService <T> {
    
    List<T> findAll();

    T findById(ObjectId id) throws ResourceNotFoundException;

    T save(T entity);

    void delete(T entity);

    void deleteById(ObjectId id);

    Long count();
}