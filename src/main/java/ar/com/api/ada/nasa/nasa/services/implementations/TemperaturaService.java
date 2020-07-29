package ar.com.api.ada.nasa.nasa.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import ar.com.api.ada.nasa.nasa.entities.Pais;
import ar.com.api.ada.nasa.nasa.entities.Temperatura;
import ar.com.api.ada.nasa.nasa.exceptions.ResourceNotFoundException;
import ar.com.api.ada.nasa.nasa.models.response.PaisResponse;
import ar.com.api.ada.nasa.nasa.models.response.TemperaturaResponse;
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

	public Temperatura saveDatos(int anio, String codigoPais, double grados) {
		return new Temperatura(anio, codigoPais, grados);
	}

	public TemperaturaResponse findByMaxTemperatura(Pais pais) {
		Temperatura temperatura = temperaturaRepository.findByCodigoPais(pais.getCodigoPais());
		TemperaturaResponse response = new TemperaturaResponse();
		response.anio = temperatura.getAnio();
		response.nombrePais = pais.getNombre();
		response.temperaturaMaxima = pais.MaxTemperatura();
		return response;
	}

	public List<PaisResponse> findByAnio(int anio) {
		List<PaisResponse> paises = new ArrayList<>();
		PaisResponse paisResponse = new PaisResponse();
		Temperatura temperatura = temperaturaRepository.findByAnio(anio);
		paisResponse.grados = temperatura.getGrados();
		paisResponse.nombrePais = temperatura.getCodigoPais();
		paises.add(paisResponse);
		return paises;
	}

	public List<TemperaturaResponse> findByPais(Pais pais) {
		List<TemperaturaResponse> temperaturas = new ArrayList<>();
		TemperaturaResponse temperaturaResponse = new TemperaturaResponse();
		Temperatura temperatura = temperaturaRepository.findByCodigoPais(pais.getCodigoPais());
		temperaturaResponse.anio = temperatura.getAnio();
		temperaturaResponse.nombrePais = temperatura.getCodigoPais();
		temperaturaResponse.temperaturaMaxima = pais.MaxTemperatura();
		temperaturas.add(temperaturaResponse);
		return temperaturas;
	}
    
}