package com.example.bodegaesfeagape.Entidades_de_Negocio;

import groovy.util.logging.Log;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "paqueteActivo")
public class PaqueteActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Log id;

    @NotNull(message = "El Correlativo es Requerido")
    private String correlativo;

    @NotNull(message = "El Nombre es Requerido")
    private String nombre;
    
    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Log getId() {
        return id;
    }

    public void setId(Log id) {
        this.id = id;
    }

}
