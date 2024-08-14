package com.example.bodegaesfeagape.Entidades_de_Negocio;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class PaqueteActivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank(message = "El correlativo es requerido")
    private String correlativo;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    public PaqueteActivo() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


}
