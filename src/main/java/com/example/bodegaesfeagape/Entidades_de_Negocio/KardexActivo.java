package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "kardexActivos")
public class KardexActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventarioActivo_id")
    private InventarioActivo inventarioActivo;

    @NotNull(message = "La fecha de movimiento es requerida")
    private LocalDateTime fechaMovimiento;

    @NotNull(message = "La cantidad es requerida")
    private int cantidad;

    @NotNull(message = "El tipo de movimiento es requerido")
    private byte tipoMovimiento;

    @NotNull(message = "El saldo es requerido")
    private int saldo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public byte getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(byte tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    
}
