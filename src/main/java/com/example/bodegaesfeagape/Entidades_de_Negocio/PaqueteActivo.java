package com.example.bodegaesfeagape.Entidades_de_Negocio;


import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


public class PaqueteActivo {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "El Correlativo es Requerido")
    private String correlativo;

    @NotNull(message = "El Nombre es Requerido")
    private String nombre;

    @OneToMany(mappedBy = "paqueteActivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleSolicitudActivo> detalleSolicitudes = new HashSet<>();

    public PaqueteActivo() {
    }


}
