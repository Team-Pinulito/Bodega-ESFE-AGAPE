package com.example.bodegaesfeagape.Entidades_de_Negocio;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "inventarioActivos")
public class InventarioActivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "activo_id")
    private Activo activo;

    @ManyToOne
    @JoinColumn(name = "estante_id")
    private Estante estante;

    @NotNull(message = "La existencia es requerida")
    private Integer existencia;

    @OneToMany(mappedBy = "inventarioActivo")
    private Set<KardexActivo> kardexActivos = new HashSet<>();

    @OneToMany(mappedBy = "inventarioActivo")
    private Set<AjusteInventario> ajusteInventarios = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public Estante getEstante() {
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Set<KardexActivo> getKardexActivos() {
        return kardexActivos;
    }

    public void setKardexActivos(Set<KardexActivo> kardexActivos) {
        this.kardexActivos = kardexActivos;
    }

    public Set<AjusteInventario> getAjusteInventarios() {
        return ajusteInventarios;
    }

    public void setAjusteInventarios(Set<AjusteInventario> ajusteInventarios) {
        this.ajusteInventarios = ajusteInventarios;
    }

    


}
