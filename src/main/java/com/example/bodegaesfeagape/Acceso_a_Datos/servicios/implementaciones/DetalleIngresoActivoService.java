package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IDetalleIngresoActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IDetalleIngresoActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.DetalleIngresoActivo;

@Service
public class DetalleIngresoActivoService implements IDetalleIngresoActivoService  {

    @Autowired
    private IDetalleIngresoActivoRepository iDetalleIngresoActivoRepository;

     @Override
    public Page<DetalleIngresoActivo> buscarTodosPaginados(Pageable pageable) {
        return iDetalleIngresoActivoRepository.findAll(pageable);
    }
    
    @Override
    public List<DetalleIngresoActivo> obtenerTodos() {
        return iDetalleIngresoActivoRepository.findAll();
    }

    @Override
    public Optional<DetalleIngresoActivo> buscarPorId(Integer id) {
        return iDetalleIngresoActivoRepository.findById(id);
    }

    @Override
    public DetalleIngresoActivo crearOEditar(DetalleIngresoActivo detalleIngresoActivo) {
        return iDetalleIngresoActivoRepository.save(detalleIngresoActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        iDetalleIngresoActivoRepository.deleteById(id);
    }

}
