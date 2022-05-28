package infra.microservices.autores.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infra.microservices.autores.models.AutorModel;
import infra.microservices.autores.repositories.AutorRepository;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public ArrayList<AutorModel> obtenerAutores(){
        return(ArrayList<AutorModel>) autorRepository.findAll();
    }

    public AutorModel guardarAutor(AutorModel autor){
        return autorRepository.save(autor);
    }

    public Optional<AutorModel> obtenerPorId(Long id){
        return autorRepository.findById(id);
    }
    public ArrayList<AutorModel> obtenerPorNombre(String nombre){
        return autorRepository.findByNombre(nombre);
    }
    public boolean eliminarAutor(Long id){
        try {
            autorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
