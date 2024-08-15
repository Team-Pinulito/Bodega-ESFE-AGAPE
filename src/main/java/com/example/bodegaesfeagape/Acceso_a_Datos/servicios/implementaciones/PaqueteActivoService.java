package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IPaqueteActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IPaqueteActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.PaqueteActivo;

public class PaqueteActivoService implements IPaqueteActivoService {

    @Autowired
    private IPaqueteActivoRepository iPaqueteActivoRepository;

     @Override
    public Page<PaqueteActivo> buscarTodosPaginados(Pageable pageable) {
        return iPaqueteActivoRepository.findAll(pageable);
    }
    
    @Override
    public List<PaqueteActivo> obtenerTodos() {
        return iPaqueteActivoRepository.findAll();
    }

    @Override
    public Optional<PaqueteActivo> buscarPorId(Integer id) {
        return iPaqueteActivoRepository.findById(id);
    }

    @Override
    public PaqueteActivo crearOEditar(PaqueteActivo iPaqueteActivo) {
        return iPaqueteActivoRepository.save(iPaqueteActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        iPaqueteActivoRepository.deleteById(id);
    }
}
