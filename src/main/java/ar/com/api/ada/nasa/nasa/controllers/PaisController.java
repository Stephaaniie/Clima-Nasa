package ar.com.api.ada.nasa.nasa.controllers;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.api.ada.nasa.nasa.entities.*;
import ar.com.api.ada.nasa.nasa.models.request.*;
import ar.com.api.ada.nasa.nasa.models.response.*;
import ar.com.api.ada.nasa.nasa.services.implementations.PaisService;
import ar.com.api.ada.nasa.nasa.services.implementations.TemperaturaService;


@RestController
public class PaisController {
    @Autowired
    PaisService sPais;

    @Autowired
    TemperaturaService sTemperatura;
        
    @GetMapping("/temperaturas/paises/{codigoPais}")
    public List<TemperaturaResponse> listarTemperatrasDeUnPaisPorAnio(@PathVariable String codigoPais) {
        
        return sTemperatura.findByPais(sPais.findById(new ObjectId(codigoPais)));
    }

    @GetMapping("/temperaturas/anios/{anio}")
    public List<PaisResponse> temperaturasPorAnio(@PathVariable int anio){
        return sTemperatura.findByAnio(anio);

    }

    @GetMapping("/temperaturas/maximas/{codigoPais}")
    public ResponseEntity<TemperaturaResponse> consultarMaximasTemperaturaPais(@PathVariable String codigoPais) { 
        return sTemperatura.findByMaxTemperatura(sPais.findById(new ObjectId(codigoPais)));
    }

    @GetMapping("/paises")
    public List<Pais> listarTodosLosPaises(@RequestParam(value = "nombre", required = true) String nombre) { 
        return  sPais.findAll();
    }

    @GetMapping("/paises/{id}")
    public Pais listarTodosLosPaisPorId(@PathVariable String id) {     
        return sPais.findById(new ObjectId(id));
    }

    @PostMapping("/paises")
    public ResponseEntity<Pais> ingresarUnPais(@RequestBody PaisRequest req) {
        Pais pais = sPais.saveDatos(req.codigoPais,req.nombre);
        return new ResponseEntity<>(sPais.save(pais), HttpStatus.CREATED);
    }

    @PostMapping("/temperaturas")
    public ResponseEntity<Temperatura> ingrearUnaTemperatura(@RequestBody TemperaturaRequest req) {
        Temperatura temperatura = sTemperatura.saveDatos(req.anio,req.codigoPais,req.grados);
        return new ResponseEntity<>(sTemperatura.save(temperatura), HttpStatus.CREATED);
    }

    @PutMapping("/paises/{id}")
    public Pais modificarNmbre(@PathVariable String id,@RequestBody Pais pais){
        pais.set_id(new ObjectId(id));
        return sPais.save(pais);
    }

    @DeleteMapping("/temperaturas/{id}")
    public String eliminarTemperatura(@PathVariable String id){
        sTemperatura.deleteById(new ObjectId(id));
        return "OK";   
    }
}