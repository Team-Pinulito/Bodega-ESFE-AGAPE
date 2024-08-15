package com.example.bodegaesfeagape.Entidades_de_Negocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "rolId", nullable = false)
    private Rol rol;

    @NotBlank(message = "El nombre es requerido")
    @Size(max = 100, message = "El nombre no debe exceder 100 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    @Size(max = 100, message = "El apellido no debe exceder 100 caracteres")
    private String apellido;

    @NotBlank(message = "El email es requerido")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotBlank(message = "El teléfono es requerido")
    @Size(min = 8, max = 15, message = "El teléfono debe tener entre 8 y 15 caracteres")
    private String telefono;

    @NotBlank(message = "El DUI es requerido")
    @Size(min = 9, max = 10, message = "El DUI debe tener entre 9 y 10 caracteres")
    private String DUI;

    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @NotBlank(message = "El código es requerido")
    private String codigo;

    @NotBlank(message = "La dirección es requerida")
    @Size(max = 255, message = "La dirección no debe exceder 255 caracteres")
    private String direccion;

    @OneToMany(mappedBy = "usuario")
    private Set<AjusteInventario> ajustesInventario = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<IngresoActivo> ingresoActivo = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<SolicitudActivo> solicitudActivo = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public @NotBlank(message = "El nombre es requerido") @Size(max = 100, message = "El nombre no debe exceder 100 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es requerido") @Size(max = 100, message = "El nombre no debe exceder 100 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El apellido es requerido") @Size(max = 100, message = "El apellido no debe exceder 100 caracteres") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "El apellido es requerido") @Size(max = 100, message = "El apellido no debe exceder 100 caracteres") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El email es requerido") @Email(message = "El email debe ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email es requerido") @Email(message = "El email debe ser válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "El teléfono es requerido") @Size(min = 8, max = 15, message = "El teléfono debe tener entre 8 y 15 caracteres") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El teléfono es requerido") @Size(min = 8, max = 15, message = "El teléfono debe tener entre 8 y 15 caracteres") String telefono) {
        this.telefono = telefono;
    }

    public @NotBlank(message = "El DUI es requerido") @Size(min = 9, max = 10, message = "El DUI debe tener entre 9 y 10 caracteres") String getDUI() {
        return DUI;
    }

    public void setDUI(@NotBlank(message = "El DUI es requerido") @Size(min = 9, max = 10, message = "El DUI debe tener entre 9 y 10 caracteres") String DUI) {
        this.DUI = DUI;
    }

    public @NotBlank(message = "La contraseña es requerida") @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "La contraseña es requerida") @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") String password) {
        this.password = password;
    }

    public @NotBlank(message = "El código es requerido") String getCodigo() {
        return codigo;
    }

    public void setCodigo(@NotBlank(message = "El código es requerido") String codigo) {
        this.codigo = codigo;
    }

    public @NotBlank(message = "La dirección es requerida") @Size(max = 255, message = "La dirección no debe exceder 255 caracteres") String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotBlank(message = "La dirección es requerida") @Size(max = 255, message = "La dirección no debe exceder 255 caracteres") String direccion) {
        this.direccion = direccion;
    }

    public Set<AjusteInventario> getAjustesInventario() {
        return ajustesInventario;
    }

    public void setAjustesInventario(Set<AjusteInventario> ajustesInventario) {
        this.ajustesInventario = ajustesInventario;
    }

    public Set<IngresoActivo> getIngresoActivo() {
        return ingresoActivo;
    }

    public void setIngresoActivo(Set<IngresoActivo> ingresoActivo) {
        this.ingresoActivo = ingresoActivo;
    }

    public Set<SolicitudActivo> getSolicitudActivo() {
        return solicitudActivo;
    }

    public void setSolicitudActivo(Set<SolicitudActivo> solicitudActivo) {
        this.solicitudActivo = solicitudActivo;
    }
}
