package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IIngresoActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IIngresoActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.IngresoActivo;

public class IngresoActivoService implements IIngresoActivoService {

    @Autowired
    private IIngresoActivoRepository iIngresoActivoRepository;

     @Override
    public Page<IngresoActivo> buscarTodosPaginados(Pageable pageable) {
        return iIngresoActivoRepository.findAll(pageable);
    }
    
    @Override
    public List<IngresoActivo> obtenerTodos() {
        return iIngresoActivoRepository.findAll();
    }

    @Override
    public Optional<IngresoActivo> buscarPorId(Integer id) {
        return iIngresoActivoRepository.findById(id);
    }

    @Override
    public IngresoActivo crearOEditar(IngresoActivo ingresoActivo) {
        return iIngresoActivoRepository.save(ingresoActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        iIngresoActivoRepository.deleteById(id);
    }
}
