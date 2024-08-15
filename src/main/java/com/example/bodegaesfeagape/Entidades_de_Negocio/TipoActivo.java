package com.example.bodegaesfeagape.Entidades_de_Negocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tipoActivo")
public class TipoActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    @Size(max = 100, message = "El nombre no debe exceder 100 caracteres")
    private String nombre;

    @Size(max = 255, message = "La descripción no debe exceder 255 caracteres")
    private String descripcion;

    @OneToMany(mappedBy = "tipoActivo")
    private Set<Activo> activo = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es requerido") @Size(max = 100, message = "El nombre no debe exceder 100 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es requerido") @Size(max = 100, message = "El nombre no debe exceder 100 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @Size(max = 255, message = "La descripción no debe exceder 255 caracteres") String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@Size(max = 255, message = "La descripción no debe exceder 255 caracteres") String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Activo> getActivo() {
        return activo;
    }

    public void setActivo(Set<Activo> activo) {
        this.activo = activo;
    }
}
