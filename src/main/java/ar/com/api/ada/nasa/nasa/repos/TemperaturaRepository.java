package ar.com.api.ada.nasa.nasa.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.api.ada.nasa.nasa.entities.Temperatura;

@Repository
public interface TemperaturaRepository extends MongoRepository<Temperatura,ObjectId> {
    
}