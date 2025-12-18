package com.mundaca.proyectospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mundaca.proyectospring.models.Categoria;
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
