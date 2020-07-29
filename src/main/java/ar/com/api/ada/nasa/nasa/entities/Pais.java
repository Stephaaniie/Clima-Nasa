package ar.com.api.ada.nasa.nasa.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Paises")
public class Pais {

    public ObjectId _id;

    private String nombre;

    private String codigoPais;
    
	private Temperatura temperatura;

	private List<Integer> temperaturas = new ArrayList<>();

	public Pais(String codigoPais, String nombre) {
		this.codigoPais = codigoPais;
		this.nombre = nombre;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperaturas.add((int) temperatura.getGrados());
		this.temperatura = temperatura;
	}

	public int MaxTemperatura(){
		return this.temperaturas.stream().max(Comparator.naturalOrder()).get();
	}
}