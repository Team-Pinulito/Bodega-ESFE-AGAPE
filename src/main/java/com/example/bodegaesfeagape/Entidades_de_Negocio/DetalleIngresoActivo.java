package com.example.bodegaesfeagape.Entidades_de_Negocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalleIngresoActivo")
public class DetalleIngresoActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int inventarioActivoId;

    @NotNull(message = "La cantidad es requerida")
    private int cantidad;

    @NotNull(message = "La cantidad es requerida")
    private double precio;
    
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



}
