package ar.com.api.ada.nasa.nasa.entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Temperaturas")
public class Temperatura {

	private ObjectId _Id;

    private int anio;

    private double grados;

	private List<Pais> paises = new ArrayList<>();

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getGrados() {
		return grados;
	}

	public void setGrados(double grados) {
		this.grados = grados;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public ObjectId get_Id() {
		return _Id;
	}

	public void set_Id(ObjectId _Id) {
		this._Id = _Id;
	}
	
}   