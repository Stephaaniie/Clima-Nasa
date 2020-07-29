package ar.com.api.ada.nasa.nasa.repos;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.api.ada.nasa.nasa.entities.Pais;
import ar.com.api.ada.nasa.nasa.entities.Temperatura;

@Repository
public interface TemperaturaRepository extends MongoRepository<Temperatura,ObjectId> {
    
    Temperatura findBy_id(ObjectId id);

    Temperatura findByAnio(int anio);

    Temperatura findByGrados(double grados);

    Temperatura findByCodigoPais(String codigoPais);    
}