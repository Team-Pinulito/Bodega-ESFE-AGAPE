package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.bodegaesfeagape.Entidades_de_Negocio.SolicitudActivo;

public interface ISolicitudActivoService {
    Page<SolicitudActivo> buscarTodosPaginados(Pageable pageable);

    List<SolicitudActivo> obtenerTodos();

    Optional<SolicitudActivo> buscarPorId(Integer id);

    SolicitudActivo crearOEditar(SolicitudActivo activo);

    void eliminarPorId(Integer id);
}
