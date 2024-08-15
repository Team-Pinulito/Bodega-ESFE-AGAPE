package com.example.bodegaesfeagape.Entidades_de_Negocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalleIngresoActivo")
public class DetalleIngresoActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventarioActivoId_id")
    private InventarioActivo inventarioActivoId;

    @NotNull(message = "La cantidad es requerida")
    private Integer cantidad;

    @NotNull(message = "El Precio es requerida")
    private double precio;
    

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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


    public InventarioActivo getInventarioActivoId() {
        return inventarioActivoId;
    }


    public void setInventarioActivoId(InventarioActivo inventarioActivoId) {
        this.inventarioActivoId = inventarioActivoId;
    }



}
