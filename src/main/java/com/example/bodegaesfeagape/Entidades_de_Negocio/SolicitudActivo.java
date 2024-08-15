package com.example.bodegaesfeagape.Entidades_de_Negocio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
@Entity
@Table(name = "solicitudActivos")
public class SolicitudActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "La fecha es requerida")
    private LocalDateTime fecha;

    @NotNull(message = "La fecha de entrega es requerida")
    private LocalDateTime fechaEntrega;

    @NotNull(message = "La fecha de recepción es requerida")
    private LocalDateTime fechaRecepcion;
    
    @NotNull(message = "El estado es requerido")
    private Byte status;
    
    @NotNull(message = "La fecha de entrega esperada es requerida")
    private LocalDateTime fechaEntregaEsperada;

    @NotNull(message = "La fecha de recepción esperada es requerida")
    private LocalDateTime fechaRecepcionEsperada;

    @NotNull(message = "El comentario es requerido")
    private String comentarios;

    @NotBlank(message = "El correlativo es requerido")
    private String correlativo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bodegueroEntrega_id")
    private Usuario bodegueroEntrega;

    @ManyToOne
    @JoinColumn(name = "bodegueroRecibe_id")
    private Usuario bodegueroRecibe;

    @OneToMany(mappedBy = "solicitudActivo")
    private Set<DetalleSolicitudActivo> detalleSolicitudActivos = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDateTime getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public LocalDateTime getFechaEntregaEsperada() {
        return fechaEntregaEsperada;
    }

    public void setFechaEntregaEsperada(LocalDateTime fechaEntregaEsperada) {
        this.fechaEntregaEsperada = fechaEntregaEsperada;
    }

    public LocalDateTime getFechaRecepcionEsperada() {
        return fechaRecepcionEsperada;
    }

    public void setFechaRecepcionEsperada(LocalDateTime fechaRecepcionEsperada) {
        this.fechaRecepcionEsperada = fechaRecepcionEsperada;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getBodegueroEntrega() {
        return bodegueroEntrega;
    }

    public void setBodegueroEntrega(Usuario bodegueroEntrega) {
        this.bodegueroEntrega = bodegueroEntrega;
    }

    public Usuario getBodegueroRecibe() {
        return bodegueroRecibe;
    }

    public void setBodegueroRecibe(Usuario bodegueroRecibe) {
        this.bodegueroRecibe = bodegueroRecibe;
    }

    public Set<DetalleSolicitudActivo> getDetalleSolicitudActivos() {
        return detalleSolicitudActivos;
    }

    public void setDetalleSolicitudActivos(Set<DetalleSolicitudActivo> detalleSolicitudActivos) {
        this.detalleSolicitudActivos = detalleSolicitudActivos;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    

}
