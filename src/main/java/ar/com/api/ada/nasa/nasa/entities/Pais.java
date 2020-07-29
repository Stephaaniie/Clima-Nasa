package ar.com.api.ada.nasa.nasa.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Paises")
public class Pais {

    public ObjectId _id;

    private Integer paisId;

    private String nombre;

    private String codigoIso;
    
	private Temperatura temperatura;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoIso() {
		return codigoIso;
	}

	public void setCodigoIso(String codigoIso) {
		this.codigoIso = codigoIso;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

}