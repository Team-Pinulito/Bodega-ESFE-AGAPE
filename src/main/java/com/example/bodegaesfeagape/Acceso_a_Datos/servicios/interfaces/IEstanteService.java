package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Estante;

public interface IEstanteService {
    Page<Estante> buscarTodosPaginados(Pageable pageable);

    List<Estante> obtenerTodos();

    Optional<Estante> buscarPorId(Integer id);

    Estante crearOEditar(Estante estante);

    void eliminarPorId(Integer id);

}
