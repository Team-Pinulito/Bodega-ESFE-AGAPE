package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.DetallePaqueteActivo;

public interface IDetallePaqueteActivoService {
    
    Page<DetallePaqueteActivo> buscarTodosPaginados(Pageable pageable);

    List<DetallePaqueteActivo> obtenerTodos();

    Optional<DetallePaqueteActivo> buscarPorId(Integer id);

    DetallePaqueteActivo crearOEditar(DetallePaqueteActivo detallePaqueteActivo);

    void eliminarPorId(Integer id);
}
