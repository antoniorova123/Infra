package infra.microservices.libros.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infra.microservices.libros.models.LibroModel;
import infra.microservices.libros.repositories.LibroRepository;

@Service
public class LibroService {
    @Autowired
    LibroRepository libroRepository;

    public ArrayList<LibroModel> obtenerLibros(){
        return(ArrayList<LibroModel>) libroRepository.findAll();
    }

    public LibroModel guardarLibro(LibroModel libro){
        return libroRepository.save(libro);
    }

    public Optional<LibroModel> obtenerPorId(Long id){
        return libroRepository.findById(id);
    }
    public ArrayList<LibroModel> obtenerPorNombre(String nombre){
        return libroRepository.findByNombre(nombre);
    }
    
    public boolean eliminarLibro(Long id){
        try {
            libroRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
