package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Activo;

@Service
public class ActivoService implements IActivoService{
    @Autowired
    private IActivoRepository activoRepository;

    @Override
    public Page<Activo> buscarTodosPaginados(Pageable pageable) {
        return activoRepository.findAll(pageable);
    }

    @Override
    public List<Activo> obtenerTodos() {
        return activoRepository.findAll();
    }

    @Override
    public Optional<Activo> buscarPorId(Integer id) {
        return activoRepository.findById(id);
    }

    @Override
    public Activo crearOEditar(Activo activo) {
        return activoRepository.save(activo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        activoRepository.deleteById(id);
    }
}
