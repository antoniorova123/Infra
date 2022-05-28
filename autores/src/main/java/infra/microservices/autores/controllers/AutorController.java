package infra.microservices.autores.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import infra.microservices.autores.models.AutorModel;
import infra.microservices.autores.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService autorService;

    @GetMapping()
    public ArrayList<AutorModel> obtenerAutores(){
        return autorService.obtenerAutores();
    }

    @PostMapping()
    public AutorModel guardarAutor(@RequestBody AutorModel autor){
        return this.autorService.guardarAutor(autor);
    }

    @GetMapping(path = "/{id}")
    public Optional<AutorModel> obtenerAutorPorId(@PathVariable("id") Long id){
        return this.autorService.obtenerPorId(id);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.autorService.eliminarAutor(id);
        if (ok){
            return "Se elimino el autor con el id" + id;
        }
        else{
            return "No pudo eliminar el autor con el id" + id;
        }
    }
}
