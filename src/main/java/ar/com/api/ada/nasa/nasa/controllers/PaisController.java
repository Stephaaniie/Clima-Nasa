package ar.com.api.ada.nasa.nasa.controllers;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.ada.nasa.nasa.entities.Pais;
import ar.com.api.ada.nasa.nasa.entities.Temperatura;
import ar.com.api.ada.nasa.nasa.models.request.PaisRequest;
import ar.com.api.ada.nasa.nasa.models.request.TemperaturaRequest;
import ar.com.api.ada.nasa.nasa.models.response.PaisResponse;
import ar.com.api.ada.nasa.nasa.models.response.TemperaturaResponse;
import ar.com.api.ada.nasa.nasa.services.implementations.PaisService;


@RestController
@RequestMapping("/api")
public class PaisController {
    @Autowired
    PaisService sPais;
        
    @GetMapping("/temperaturas/paises/{codigoPais}")
    public List<TemperaturaResponse> listarTemperatrasDeUnPaisPorAnio(@PathVariable String codigoPais) {
        
        return sPais.findByPais(sPais.findById(new ObjectId(codigoPais)));
    }

    @GetMapping("/temperaturas/anios/{anio}")
    public List<PaisResponse> temperaturasPorAnio(@PathVariable int anio){
        return sPais.findByAnio(anio);

    }

    @GetMapping("/temperaturas/maximas/{codigoPais}")
    public TemperaturaResponse consultarMaximasTemperaturaPais(@PathVariable String codigoPais) { 
        return sPais.findByMaxTemperatura(sPais.findById(new ObjectId(codigoPais)));
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
        Temperatura temperatura = sPais.saveDatos(req.anio,req.codigoPais,req.grados);
        return new ResponseEntity<>(sPais.save(temperatura), HttpStatus.CREATED);
    }

    @PutMapping("/paises/{id}")
    public Pais modificarNmbre(@PathVariable String id,@RequestBody Pais pais){
        pais.set_id(new ObjectId(id));
        return sPais.save(pais);
    }

    @DeleteMapping("/temperaturas/{id}")
    public String eliminarTemperatura(@PathVariable String id){
        sPais.deleteById(new ObjectId(id));
        return "OK";   
    }
}