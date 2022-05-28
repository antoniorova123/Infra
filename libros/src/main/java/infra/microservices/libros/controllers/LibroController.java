package infra.microservices.libros.controllers;

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

import infra.microservices.libros.models.LibroModel;
import infra.microservices.libros.services.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    LibroService libroService;

    @GetMapping()
    public ArrayList<LibroModel> obtenerLibros(){
        return libroService.obtenerLibros();
    }

    @PostMapping()
    public LibroModel guardarLibro(@RequestBody LibroModel libro){
        return this.libroService.guardarLibro(libro);
    }

    @GetMapping(path = "/{id}")
    public Optional<LibroModel> obtenerLibroPorId(@PathVariable("id") Long id){
        return this.libroService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.libroService.eliminarLibro(id);
        if (ok){
            return "Se elimin[o el usuario con id" + id;
        }
        else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
