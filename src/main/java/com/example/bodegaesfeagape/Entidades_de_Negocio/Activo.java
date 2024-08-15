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
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Activos")
public class Activo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La descripción es requerida")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "estante_id")
    private Estante estante;

    @ManyToOne
    @JoinColumn(name = "tipoActivo_id")
    private TipoActivo tipoActivo;

    @NotBlank(message = "El codigo es requerido")
    private String codigo;

    @NotBlank(message = "El codigo de barras es requerido")
    private String codigoDeBarra;

    @OneToMany(mappedBy = "activo")
    private Set<DetalleSolicitudActivo> detalleSolicitudActivos = new HashSet<>();

    @OneToMany(mappedBy = "activo")
    private Set<DetallePaqueteActivo> detallePaqueteActivos = new HashSet<>();

    @OneToMany(mappedBy = "activo")
    private Set<InventarioActivo> inventarioActivos = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estante getEstante() {
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }

    public TipoActivo getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(TipoActivo tipoActivo) {
        this.tipoActivo = tipoActivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoDeBarra() {
        return codigoDeBarra;
    }

    public Set<DetalleSolicitudActivo> getDetalleSolicitudActivos() {
        return detalleSolicitudActivos;
    }

    public void setDetalleSolicitudActivos(Set<DetalleSolicitudActivo> detalleSolicitudActivos) {
        this.detalleSolicitudActivos = detalleSolicitudActivos;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        this.codigoDeBarra = codigoDeBarra;
    }

    
}
