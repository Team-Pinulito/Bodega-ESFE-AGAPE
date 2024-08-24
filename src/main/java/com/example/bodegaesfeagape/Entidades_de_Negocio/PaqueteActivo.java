package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "paqueteActivo")
public class PaqueteActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El Correlativo es Requerido")
    private String correlativo;

    @NotNull(message = "El Nombre es Requerido")
    private String nombre;
    
    @OneToMany(mappedBy = "paqueteActivo")
    private Set<DetallePaqueteActivo> detallePaqueteActivos = new HashSet<>();

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<DetallePaqueteActivo> getDetallePaqueteActivos() {
        return detallePaqueteActivos;
    }

    public void setDetallePaqueteActivos(Set<DetallePaqueteActivo> detallePaqueteActivos) {
        this.detallePaqueteActivos = detallePaqueteActivos;
    }

   
}
