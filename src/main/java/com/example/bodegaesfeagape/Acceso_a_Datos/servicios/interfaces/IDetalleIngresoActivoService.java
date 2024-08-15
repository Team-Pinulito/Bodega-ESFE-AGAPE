package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.DetalleIngresoActivo;

public interface IDetalleIngresoActivoService {

    Page<DetalleIngresoActivo> buscarTodosPaginados(Pageable pageable);

    List<DetalleIngresoActivo> obtenerTodos();

    Optional<DetalleIngresoActivo> buscarPorId(Integer id);

    DetalleIngresoActivo crearOEditar(DetalleIngresoActivo bodega);

    void eliminarPorId(Integer id);
}
