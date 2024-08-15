package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class DetalleIngresoActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int inventarioActivoId;

    @NotNull(message = "La cantidad es requerida")
    private int cantidad;

    @NotNull(message = "La cantidad es requerida")
    private double precio;

    @OneToMany(mappedBy = "DetalleIngresoActivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IngresoActivo> ingresoActivos = new HashSet<>();

    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getInventarioActivoId() {
        return inventarioActivoId;
    }


    public void setInventarioActivoId(int inventarioActivoId) {
        this.inventarioActivoId = inventarioActivoId;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public Set<IngresoActivo> getIngresoActivos() {
        return ingresoActivos;
    }


    public void setIngresoActivos(Set<IngresoActivo> ingresoActivos) {
        this.ingresoActivos = ingresoActivos;
    }


}
