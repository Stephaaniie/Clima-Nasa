package ar.com.api.ada.nasa.nasa.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Temperaturas")
public class Temperatura {

	private ObjectId _Id;

    private int anio;

    private double grados;

	private String codigoPais;

	public Temperatura(int anio, String codigoPais, double grados) {
		this.anio = anio;

		this.grados = grados;

		this.codigoPais = codigoPais;
	}

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

	public ObjectId get_Id() {
		return _Id;
	}

	public void set_Id(ObjectId _Id) {
		this._Id = _Id;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
}   