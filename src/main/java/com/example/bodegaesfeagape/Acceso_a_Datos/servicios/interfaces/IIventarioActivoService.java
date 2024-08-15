package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import com.example.bodegaesfeagape.Entidades_de_Negocio.InventarioActivo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IIventarioActivoService {

    Page<InventarioActivo> buscarTodosPaginados(Pageable pageable);

    List<InventarioActivo> obtenerTodos();

    Optional<InventarioActivo> buscarPorId(Integer id);

    InventarioActivo crearOEditar(InventarioActivo activo);

    void eliminarPorId(Integer id);
}
