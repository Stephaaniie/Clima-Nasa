package ar.com.api.ada.nasa.nasa.repos;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.api.ada.nasa.nasa.entities.Pais;
import ar.com.api.ada.nasa.nasa.entities.Temperatura;

@Repository
public interface PaisRepository extends MongoRepository<Pais,ObjectId>{
   
    Pais findBy_id(ObjectId id);

    Pais  findByNombre(String nombre);

    Pais findByCodigoPais(String codigoPais);

    Pais findByTemperatura(Temperatura temperatura);
}