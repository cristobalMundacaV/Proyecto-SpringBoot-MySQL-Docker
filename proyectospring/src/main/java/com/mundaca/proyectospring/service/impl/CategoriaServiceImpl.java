package com.mundaca.proyectospring.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.mundaca.proyectospring.models.Categoria;
import com.mundaca.proyectospring.repository.CategoriaRepository;
import com.mundaca.proyectospring.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id){
        return categoriaRepository.findById(id);
    }
    @Override
    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    @Override
    public Categoria update(Long id,Categoria categoria){
        return categoriaRepository.findById(id)
        .map(c -> {
            c.setNombre(categoria.getNombre());
            return categoriaRepository.save(c);
        })
        .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }
    @Override
    public void deleteById(Long id){
        categoriaRepository.deleteById(id);
    }
}
