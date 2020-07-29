package ar.com.api.ada.nasa.nasa.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;

public class Temperatura {

    private int temperaturaId;

    private int anio;

    private double grados;

    //private List<Pais> paises = new ArrayList<>();
}   