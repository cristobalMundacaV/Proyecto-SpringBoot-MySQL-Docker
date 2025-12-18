package com.mundaca.proyectospring.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mundaca.proyectospring.models.Categoria;
import com.mundaca.proyectospring.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        return categoriaService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria){
        Categoria nuevaCategoria=categoriaService.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(
        @PathVariable Long id,
        @Valid @RequestBody Categoria categoria){
            Categoria categoriaActualizada = categoriaService.update(id,categoria);
            return ResponseEntity.ok(categoriaActualizada);
        }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
