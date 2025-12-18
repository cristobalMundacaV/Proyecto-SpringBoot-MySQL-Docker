package com.mundaca.proyectospring.service;
import java.util.List;
import java.util.Optional;

import com.mundaca.proyectospring.models.Categoria;

public interface CategoriaService {

    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    Categoria update(Long id,Categoria categoria);
    void deleteById(Long id);
}
