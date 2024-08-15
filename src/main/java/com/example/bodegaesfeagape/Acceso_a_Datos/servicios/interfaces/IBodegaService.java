package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Bodega;

public interface IBodegaService {
    Page<Bodega> buscarTodosPaginados(Pageable pageable);

    List<Bodega> obtenerTodos();

    Optional<Bodega> buscarPorId(Integer id);

    Bodega crearOEditar(Bodega bodega);

    void eliminarPorId(Integer id);
}
