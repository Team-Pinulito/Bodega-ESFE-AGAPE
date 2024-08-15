package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class IngresoActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int usuarioId;

    @NotNull(message = "La fecha de ingreso es requerida")
    private Date fechaIngreso;

    @NotNull(message = "El correlativo es requerido")
    private String correlativo;

    private String numeroDocRelacionado;

    private double total;

    @OneToMany(mappedBy = "ingresoActivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Usuario> usuarios = new HashSet<>();


    
    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public int getUsuarioId() {
        return usuarioId;
    }



    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }



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



    public double getTotal() {
        return total;
    }



    public void setTotal(double total) {
        this.total = total;
    }



    public Set<Usuario> getUsuarios() {
        return usuarios;
    }



    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


}
