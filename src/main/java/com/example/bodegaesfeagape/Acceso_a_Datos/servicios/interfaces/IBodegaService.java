package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Bodega;

public interface IBodegaService {
    List<Bodega> obtenerTodos();

    Optional<Bodega> buscarPorId(Integer id);

    Bodega crearOEditar(Bodega bodega);

    void eliminarPorId(Integer id);
}
