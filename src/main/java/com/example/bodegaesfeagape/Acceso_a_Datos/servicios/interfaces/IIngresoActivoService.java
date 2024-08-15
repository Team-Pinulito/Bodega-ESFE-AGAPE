package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.IngresoActivo;

public interface IIngresoActivoService {

    Page<IngresoActivo> buscarTodosPaginados(Pageable pageable);

    List<IngresoActivo> obtenerTodos();

    Optional<IngresoActivo> buscarPorId(Integer id);

    IngresoActivo crearOEditar(IngresoActivo bodega);

    void eliminarPorId(Integer id);
}
