package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.TipoActivo;

import java.util.List;
import java.util.Optional;

public interface ITipoActivoService {
    Page<TipoActivo> buscarTodosPaginados(Pageable pageable);

    List<TipoActivo> obtenerTodos();

    Optional<TipoActivo> buscarPorId(Integer id);

    TipoActivo crearOEditar(TipoActivo tipoActivo);

    void eliminarPorId(Integer id);
}
