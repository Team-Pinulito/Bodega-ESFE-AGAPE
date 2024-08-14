package com.example.bodegaesfeagape.Entidades_de_Negocio;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class DetalleSolicitudActivo {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long solicitudActivoId;
    private int activoId;
    @NotNull(message = "La cantidad es requerida")
    private int cantidad;
    @NotNull(message = "El estatus es requerido")
    private byte estatus;

    @ManyToOne
    @JoinColumn(name = "paqueteActivoId", nullable = true)
    private PaqueteActivo paqueteActivo;
}
