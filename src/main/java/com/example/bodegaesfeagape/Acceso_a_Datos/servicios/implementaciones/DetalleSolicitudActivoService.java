package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IDetalleSolicitudActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IDetalleSolicitudActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.DetalleSolicitudActivo;

public class DetalleSolicitudActivoService implements IDetalleSolicitudActivoService  {

    @Autowired
    private IDetalleSolicitudActivoRepository iDetalleSolicitudActivoRepository;

     @Override
    public Page<DetalleSolicitudActivo> buscarTodosPaginados(Pageable pageable) {
        return iDetalleSolicitudActivoRepository.findAll(pageable);
    }
    
    @Override
    public List<DetalleSolicitudActivo> obtenerTodos() {
        return iDetalleSolicitudActivoRepository.findAll();
    }

    @Override
    public Optional<DetalleSolicitudActivo> buscarPorId(Integer id) {
        return iDetalleSolicitudActivoRepository.findById(id);
    }

    @Override
    public DetalleSolicitudActivo crearOEditar(DetalleSolicitudActivo detalleSolicitudActivo) {
        return iDetalleSolicitudActivoRepository.save(detalleSolicitudActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        iDetalleSolicitudActivoRepository.deleteById(id);
    }

}
