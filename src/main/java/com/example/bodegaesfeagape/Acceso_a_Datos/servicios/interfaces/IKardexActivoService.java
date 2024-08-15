package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.KardexActivo;

public interface IKardexActivoService {
    Page<KardexActivo> buscarTodosPaginados(Pageable pageable);

    List<KardexActivo> obtenerTodos();

    Optional<KardexActivo> buscarPorId(Integer id);

    KardexActivo crearOEditar(KardexActivo kardexActivo);

    void eliminarPorId(Integer id);
}
