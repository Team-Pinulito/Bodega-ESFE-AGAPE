package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalleIngresoActivo")
public class DetalleIngresoActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "inventarioActivoId_id")
    private InventarioActivo inventarioActivoId;

    @NotNull(message = "La cantidad es requerida")
    private Integer cantidad;

    @NotNull(message = "El Precio es requerida")
    private BigDecimal precio;
    

   


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public InventarioActivo getInventarioActivoId() {
        return inventarioActivoId;
    }


    public void setInventarioActivoId(InventarioActivo inventarioActivoId) {
        this.inventarioActivoId = inventarioActivoId;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public BigDecimal getPrecio() {
        return precio;
    }


    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }



}
