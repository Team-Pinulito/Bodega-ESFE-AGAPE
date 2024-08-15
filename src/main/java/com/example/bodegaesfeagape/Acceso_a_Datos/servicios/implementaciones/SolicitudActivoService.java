package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.ISolicitudActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.ISolicitudActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.SolicitudActivo;

public class SolicitudActivoService implements ISolicitudActivoService{
    @Autowired
    private ISolicitudActivoRepository solicitudActivoRepository;

     @Override
    public Page<SolicitudActivo> buscarTodosPaginados(Pageable pageable) {
        return solicitudActivoRepository.findAll(pageable);
    }

    @Override
    public List<SolicitudActivo> obtenerTodos() {
        return solicitudActivoRepository.findAll();
    }

    @Override
    public Optional<SolicitudActivo> buscarPorId(Integer id) {
        return solicitudActivoRepository.findById(id);
    }

    @Override
    public SolicitudActivo crearOEditar(SolicitudActivo solicitudActivo) {
        return solicitudActivoRepository.save(solicitudActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        solicitudActivoRepository.deleteById(id);
    }
}
