package ar.com.api.ada.nasa.nasa.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.ada.nasa.nasa.entities.Pais;
import ar.com.api.ada.nasa.nasa.entities.Temperatura;
import ar.com.api.ada.nasa.nasa.services.implementations.PaisService;
import ar.com.api.ada.nasa.nasa.services.implementations.TemperaturaService;


@RestController
public class PaisController {
    @Autowired
    PaisService sPais;

    @Autowired
    TemperaturaService sTemperatura;
    
    @GetMapping("/temperaturas/paises/{codigoPais}")
    public ResponseEntity<List<Temperatura>> listarTemperatrasDeUnPaisPorAnio(@PathVariable Integer codigoPais) {
    
        return null;
    }

    @GetMapping("/temperaturas/anios/{anio}")
    public ResponseEntity<List<Pais>> temperaturasPorAnio(@PathVariable Integer anio){
		return null;
    }

    @GetMapping("/temperaturas/maximas/{codigoPais}")
    public ResponseEntity<Temperatura> consultarMaximasTemperaturaPais(@PathVariable String codigoPais) { 

        return null;
    }

    @GetMapping("/paises")
    public ResponseEntity<List<Pais>> listarTodosLosPaises(@RequestParam(value = "nombre", required = true) String nombre) { 
        return  null;
    }

    @GetMapping("/paises/{id}")
    public ResponseEntity<List<Pais>> listarTodosLosPaisPorId(@PathVariable Integer id) {
        return null;
    }

    @PostMapping("/paises")
    public ResponseEntity<?> ingresarUnPais(@RequestBody Pais req) {
        return null;
    }

    @PostMapping("/temperaturas")
    public ResponseEntity<?> ingrearUnaTemperatura(@RequestBody Temperatura temperatura) {
        return null;
    }

    @PutMapping("/paises/{id}")
    public ResponseEntity<?> modificarNmbre(@PathVariable Integer id, @RequestBody Pais request){
        return null;
    }

    @DeleteMapping("/temperaturas/{id}")
    public ResponseEntity<?> eliminarTemperatura(@PathVariable Integer id){
        return null; 
    }
}