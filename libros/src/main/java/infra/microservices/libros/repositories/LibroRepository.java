package infra.microservices.libros.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infra.microservices.libros.models.LibroModel;

@Repository
public interface LibroRepository extends CrudRepository<LibroModel, Long>{
    public abstract ArrayList<LibroModel> findByNombre(String nombre);
}