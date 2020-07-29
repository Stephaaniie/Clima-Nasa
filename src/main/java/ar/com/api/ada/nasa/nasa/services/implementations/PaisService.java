package ar.com.api.ada.nasa.nasa.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import ar.com.api.ada.nasa.nasa.entities.Pais;
import ar.com.api.ada.nasa.nasa.exceptions.ResourceNotFoundException;
import ar.com.api.ada.nasa.nasa.repos.PaisRepository;
import ar.com.api.ada.nasa.nasa.services.IPaisSrevice;

@Service
public class PaisService implements IPaisSrevice{

	private final PaisRepository paisRepository;

	public PaisService(PaisRepository paisRepository){
		this.paisRepository = paisRepository;
	}

	@Override
	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	@Override
	public Pais findById(ObjectId id) throws ResourceNotFoundException {
		return  paisRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	@Override
	public Pais save(Pais pais) {
		return paisRepository.save(pais);
	}

	@Override
	public void delete(Pais pais) {
		this.deleteById(pais.get_id());
	}

	@Override
	public void deleteById(ObjectId id) {
		if (!paisRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        paisRepository.deleteById(id);
	}

	@Override
	public Long count() {
		return paisRepository.count();
	}

	public Pais saveDatos(String codigoPais, String nombre) {
		return new Pais(codigoPais,nombre);
	}
}