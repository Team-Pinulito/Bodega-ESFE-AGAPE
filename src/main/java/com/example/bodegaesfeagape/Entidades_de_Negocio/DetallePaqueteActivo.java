package com.example.bodegaesfeagape.Entidades_de_Negocio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "detallePaqueteActivo")
public class DetallePaqueteActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "paqueteActivo_id")
    private PaqueteActivo paqueteActivo;

    @ManyToOne
    @JoinColumn(name = "activo_id")
    private Activo Activo;

    @NotNull(message = "La cantidad es requerida")
    private int cantidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaqueteActivo getPaqueteActivo() {
        return paqueteActivo;
    }

    public void setPaqueteActivo(PaqueteActivo paqueteActivo) {
        this.paqueteActivo = paqueteActivo;
    }

    public Activo getActivo() {
        return Activo;
    }

    public void setActivo(Activo activo) {
        Activo = activo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
}
