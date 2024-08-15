package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.DetalleSolicitudActivo;

public interface IDetalleSolicitudActivoService {

    Page<DetalleSolicitudActivo> buscarTodosPaginados(Pageable pageable);

    List<DetalleSolicitudActivo> obtenerTodos();

    Optional<DetalleSolicitudActivo> buscarPorId(Integer id);

    DetalleSolicitudActivo crearOEditar(DetalleSolicitudActivo bodega);

    void eliminarPorId(Integer id);
}
