package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.PaqueteActivo;

public interface IPaqueteActivoService {

    Page<PaqueteActivo> buscarTodosPaginados(Pageable pageable);

    List<PaqueteActivo> obtenerTodos();

    Optional<PaqueteActivo> buscarPorId(Integer id);

    PaqueteActivo crearOEditar(PaqueteActivo paqueteActivo);

    void eliminarPorId(Integer id);
}
