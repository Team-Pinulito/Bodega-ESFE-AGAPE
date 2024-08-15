package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import com.example.bodegaesfeagape.Entidades_de_Negocio.AjusteInventario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAjusteInventarioService {
    Page<AjusteInventario> buscarTodosPaginados(Pageable pageable);

    List<AjusteInventario> obtenerTodos();

    Optional<AjusteInventario> buscarPorId(Integer id);

    AjusteInventario crearOEditar(AjusteInventario ajusteInventario);

    void eliminarPorId(Integer id);
}
