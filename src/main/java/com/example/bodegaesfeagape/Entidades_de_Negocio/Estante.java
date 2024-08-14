package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "estantes")
public class Estante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "bodega_id")
    private Bodega bodega;

    @NotBlank(message = "La descripción es requerida")
    private String descripcion;

    @OneToMany(mappedBy = "activo")
    private Set<Activo> activos = new HashSet<>();

    @OneToMany(mappedBy = "activo")
    private Set<InventarioActivo> inventarioActivos = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Activo> getActivos() {
        return activos;
    }

    public void setActivos(Set<Activo> activos) {
        this.activos = activos;
    }

    public Set<InventarioActivo> getInventarioActivos() {
        return inventarioActivos;
    }

    public void setInventarioActivos(Set<InventarioActivo> inventarioActivos) {
        this.inventarioActivos = inventarioActivos;
    }

    
}
