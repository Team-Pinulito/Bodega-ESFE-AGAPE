package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IngresoActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int usuarioId;
    @NotNull(message = "La fecha es requerida")
    private Date fechaIngreso;
    @NotBlank(message = "El correlativo es requerido")
    private String correlativo;
    @NotBlank(message = "El Numero del Documento es requerido")
    private String numeroDocRelacionado;
    private double total;
    @OneToMany(mappedBy = "ingresoActivo")
    private List<DetalleIngresoActivo> detalleIngresos;

}
