package com.mundaca.proyectospring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mundaca.proyectospring.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{

}
