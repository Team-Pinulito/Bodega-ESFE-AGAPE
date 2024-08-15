package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "kardexActivos")
public class KardexActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "inventarioActivo_id")
    private InventarioActivo inventarioActivo;

    @NotNull(message = "La fecha de movimiento es requerida")
    private LocalDateTime fechaMovimiento;

    @NotNull(message = "La cantidad es requerida")
    private Integer cantidad;

    @NotNull(message = "El tipo de movimiento es requerido")
    private byte tipoMovimiento;

    @NotNull(message = "El saldo es requerido")
    private Integer saldo;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public InventarioActivo getInventarioActivo() {
        return inventarioActivo;
    }

    public void setInventarioActivo(InventarioActivo inventarioActivo) {
        this.inventarioActivo = inventarioActivo;
    }

    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

   

    public byte getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(byte tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    
    
}
