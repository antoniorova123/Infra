package infra.microservices.libros.models;

import javax.persistence.*;


@Entity
@Table(name = "libro")
public class LibroModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String autor;
    private int nPaginas;
    public Long getId() {
        return id;
    }
    public int getnPaginas() {
        return nPaginas;
    }
    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
