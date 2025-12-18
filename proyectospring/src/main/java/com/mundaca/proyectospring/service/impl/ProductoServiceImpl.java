package com.mundaca.proyectospring.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.mundaca.proyectospring.models.Producto;
import com.mundaca.proyectospring.repository.ProductoRepository;
import com.mundaca.proyectospring.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
    private final ProductoRepository productoRepository;
    
    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }
    @Override
    public List<Producto> findAll(){
        return productoRepository.findAll();
    };

    @Override
    public Optional<Producto> findById(Long id){
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Long id, Producto producto){
        return productoRepository.findById(id).map(p -> {
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            p.setStock(producto.getStock());
            return productoRepository.save(p);
        })
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void deleteById(Long id){
        productoRepository.deleteById(id);
    }
}
