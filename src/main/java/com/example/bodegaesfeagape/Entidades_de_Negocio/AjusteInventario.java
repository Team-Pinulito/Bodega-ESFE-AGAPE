package com.example.bodegaesfeagape.Entidades_de_Negocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ajusteinventarios")
public class AjusteInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "La fecha de ingreso es requerida")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;

    @NotNull(message = "El correlativo es requerido")
    private Integer correlativo;

    @NotNull(message = "La cantidad es requerida")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private Integer cantidad;

    @NotNull(message = "El tipo de mantenimiento es requerido")
    private Integer tipoMantenimiento;

    @Size(max = 255, message = "El comentario no debe exceder 255 caracteres")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "inventarioActivoId", nullable = false)
    private InventarioActivo inventarioActivo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "La fecha de ingreso es requerida") Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(@NotNull(message = "La fecha de ingreso es requerida") Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public @NotNull(message = "El correlativo es requerido") Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(@NotNull(message = "El correlativo es requerido") Integer correlativo) {
        this.correlativo = correlativo;
    }

    public @NotNull(message = "La cantidad es requerida") @Min(value = 1, message = "La cantidad debe ser mayor a 0") Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(@NotNull(message = "La cantidad es requerida") @Min(value = 1, message = "La cantidad debe ser mayor a 0") Integer cantidad) {
        this.cantidad = cantidad;
    }

    public @NotNull(message = "El tipo de mantenimiento es requerido") Integer getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(@NotNull(message = "El tipo de mantenimiento es requerido") Integer tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public @Size(max = 255, message = "El comentario no debe exceder 255 caracteres") String getComentario() {
        return comentario;
    }

    public void setComentario(@Size(max = 255, message = "El comentario no debe exceder 255 caracteres") String comentario) {
        this.comentario = comentario;
    }

    public InventarioActivo getInventarioActivo() {
        return inventarioActivo;
    }

    public void setInventarioActivo(InventarioActivo inventarioActivo) {
        this.inventarioActivo = inventarioActivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
