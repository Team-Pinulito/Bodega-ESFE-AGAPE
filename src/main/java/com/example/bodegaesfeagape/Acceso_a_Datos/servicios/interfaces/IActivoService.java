package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Activo;

public interface IActivoService {

    Page<Activo> buscarTodosPaginados(Pageable pageable);

    List<Activo> obtenerTodos();

    Optional<Activo> buscarPorId(Integer id);

    Activo crearOEditar(Activo activo);

    void eliminarPorId(Integer id);
}
