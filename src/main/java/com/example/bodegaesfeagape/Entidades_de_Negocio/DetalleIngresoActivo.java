package com.example.bodegaesfeagape.Entidades_de_Negocio;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class DetalleIngresoActivo {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "ingresoActivoId")
    private IngresoActivo ingresoActivo;
    private int inventarioActivoId;
    @NotNull(message = "La cantidad es requerida")
    private int cantidad;
    @NotNull(message = "La cantidad es requerida")
    private double precio;
}
