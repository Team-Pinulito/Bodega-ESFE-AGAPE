package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRolService {
    Page<Rol> buscarTodosPaginados(Pageable pageable);

    List<Rol> obtenerTodos();

    Optional<Rol> buscarPorId(Integer id);

    Rol crearOEditar(Rol rol);

    void eliminarPorId(Integer id);
}
