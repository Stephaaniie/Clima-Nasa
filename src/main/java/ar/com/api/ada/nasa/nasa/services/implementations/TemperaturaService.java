package ar.com.api.ada.nasa.nasa.services.implementations;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import ar.com.api.ada.nasa.nasa.entities.Temperatura;
import ar.com.api.ada.nasa.nasa.exceptions.ResourceNotFoundException;
import ar.com.api.ada.nasa.nasa.repos.TemperaturaRepository;
import ar.com.api.ada.nasa.nasa.services.ITemperaturaService;

@Service
public class TemperaturaService implements ITemperaturaService {

    private final TemperaturaRepository temperaturaRepository;
    
    public TemperaturaService(TemperaturaRepository temperaturaRepository){
        this.temperaturaRepository = temperaturaRepository;
    }

	@Override
	public List<Temperatura> findAll() {
		return temperaturaRepository.findAll();
	}

	@Override
	public Temperatura findById(ObjectId id) throws ResourceNotFoundException {
		return  temperaturaRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	@Override
	public Temperatura save(Temperatura temperatura) {
		return temperaturaRepository.save(temperatura);
	}

	@Override
	public void delete(Temperatura temperatura) {
		this.deleteById(temperatura.get_Id());
	}

	@Override
	public void deleteById(ObjectId id) {
		if (!temperaturaRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        temperaturaRepository.deleteById(id);
	}

	@Override
	public Long count() {
		return temperaturaRepository.count();
	}
    
}