package com.mundaca.proyectospring.service;
import java.util.List;
import java.util.Optional;
import com.mundaca.proyectospring.models.Producto;


public interface ProductoService {

    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    Producto update(Long id,Producto producto);
    void deleteById(Long id);
}
