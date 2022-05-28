package infra.microservices.autores.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import infra.microservices.autores.models.AutorModel;

@Repository
public interface AutorRepository extends CrudRepository<AutorModel, Long>{
    public abstract ArrayList<AutorModel> findByNombre(String nombre);
}
