package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ingresoActivo")
public class IngresoActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;

    @NotNull(message = "La fecha de ingreso es requerida")
    private Date fechaIngreso;

    @NotNull(message = "El correlativo es requerido")
    private String correlativo;

    @NotBlank(message = "El Numero de Documento es requerido")
    private String numeroDocRelacionado;

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getNumeroDocRelacionado() {
        return numeroDocRelacionado;
    }

    public void setNumeroDocRelacionado(String numeroDocRelacionado) {
        this.numeroDocRelacionado = numeroDocRelacionado;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

}
