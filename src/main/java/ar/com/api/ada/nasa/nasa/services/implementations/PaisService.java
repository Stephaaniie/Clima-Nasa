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
import ar.com.api.ada.nasa.nasa.repos.PaisRepository;
import ar.com.api.ada.nasa.nasa.repos.TemperaturaRepository;
import ar.com.api.ada.nasa.nasa.services.IPaisSrevice;

@Service
public class PaisService implements IPaisSrevice{

	private final PaisRepository paisRepository;

	private final TemperaturaRepository temperaturaRepository;

	public PaisService(PaisRepository paisRepository, TemperaturaRepository temperaturaRepository){
		this.paisRepository = paisRepository;
		this.temperaturaRepository = temperaturaRepository;
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
    
	public List<Temperatura> findAllTemperatura() {
		return temperaturaRepository.findAll();
	}

	public Temperatura findByIdTemperatura(ObjectId id) throws ResourceNotFoundException {
		return  temperaturaRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("model with id " + id + " not found"));
	}

	public Temperatura save(Temperatura temperatura) {
		return temperaturaRepository.save(temperatura);
	}

	public void delete(Temperatura temperatura) {
		this.deleteByIdTemperatura(temperatura.get_Id());
	}

	public void deleteByIdTemperatura(ObjectId id) {
		if (!temperaturaRepository.existsById(id)){
            throw new ResourceNotFoundException("model with id " + id + " not found");
        }
        temperaturaRepository.deleteById(id);
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