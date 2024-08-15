package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Estante;

public interface IEstanteService {
    List<Estante> obtenerTodos();

    Optional<Estante> buscarPorId(Integer id);

    Estante crearOEditar(Estante estante);

    void eliminarPorId(Integer id);

}
