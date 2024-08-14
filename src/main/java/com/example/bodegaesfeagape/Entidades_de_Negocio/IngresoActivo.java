package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.Date;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private Set<DetalleIngresoActivo> detalleIngresos = new HashSet<>();

    public IngresoActivo() {
    }

}
