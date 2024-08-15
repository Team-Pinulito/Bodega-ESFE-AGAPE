package com.example.bodegaesfeagape.Entidades_de_Negocio;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detalleSolicitudActivo")
public class DetalleSolicitudActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "solicitudActivo_id")
    private SolicitudActivo solicitudActivo;
    
    @ManyToOne
    @JoinColumn(name = "Activo_id")
    private Activo activoId;

    @NotNull(message = "La cantidad es requerida")
    private Integer cantidad;

    @NotNull(message = "El estatus es requerido")
    private byte estatus;

    

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    public SolicitudActivo getSolicitudActivo() {
        return solicitudActivo;
    }

    public void setSolicitudActivo(SolicitudActivo solicitudActivo) {
        this.solicitudActivo = solicitudActivo;
    }

    public Activo getActivoId() {
        return activoId;
    }

    public void setActivoId(Activo activoId) {
        this.activoId = activoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
}
