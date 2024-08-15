package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.bodegaesfeagape.Entidades_de_Negocio.KardexActivo;

public interface IKardexActivoService {
    List<KardexActivo> obtenerTodos();

    Optional<KardexActivo> buscarPorId(Integer id);

    KardexActivo crearOEditar(KardexActivo kardexActivo);

    void eliminarPorId(Integer id);
}
