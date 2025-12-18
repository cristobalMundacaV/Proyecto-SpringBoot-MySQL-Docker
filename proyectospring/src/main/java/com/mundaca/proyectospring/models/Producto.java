package com.mundaca.proyectospring.models;
import java.math.BigDecimal;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no puede estar en blanco.")
    @Column(nullable = false)
    private String nombre;

    @NotNull(message = "El precio no puede estar en blanco.")
    @Positive(message = "El precio debe ser mayor a cero")
    @Column(nullable = false)
    private BigDecimal precio;

    @NotNull(message = "El stock no puede estar en blanco.")
    @PositiveOrZero(message = "El stock no puede ser negativo.")
    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categoria_id",nullable=false)
    @NotNull(message = "La categoria es obligaroria")
    private Categoria categoria;

    public Producto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    

}
