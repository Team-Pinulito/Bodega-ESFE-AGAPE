package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class DetalleSolicitudActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long solicitudActivoId;
    private int activoId;
    @NotNull(message = "La cantidad es requerida")
    private int cantidad;
    @NotNull(message = "El estatus es requerido")
    private byte estatus;

    @OneToMany(mappedBy = "paqueteActivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleSolicitudActivo> detalleSolicitudes = new HashSet<>();
    

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public long getSolicitudActivoId() {
        return solicitudActivoId;
    }


    public void setSolicitudActivoId(long solicitudActivoId) {
        this.solicitudActivoId = solicitudActivoId;
    }


    public int getActivoId() {
        return activoId;
    }


    public void setActivoId(int activoId) {
        this.activoId = activoId;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public byte getEstatus() {
        return estatus;
    }


    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }


    public Set<DetalleSolicitudActivo> getDetalleSolicitudes() {
        return detalleSolicitudes;
    }


    public void setDetalleSolicitudes(Set<DetalleSolicitudActivo> detalleSolicitudes) {
        this.detalleSolicitudes = detalleSolicitudes;
    }


    public DetalleSolicitudActivo(Set<DetalleSolicitudActivo> detalleSolicitudes) {
        this.detalleSolicitudes = detalleSolicitudes;
    }

}
