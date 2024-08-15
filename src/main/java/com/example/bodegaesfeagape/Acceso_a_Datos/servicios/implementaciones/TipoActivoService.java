package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.ITipoActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.ITipoActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.TipoActivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoActivoService implements ITipoActivoService {
    @Autowired
    private ITipoActivoRepository tipoActivoRepository;

    @Override
    public Page<TipoActivo> buscarTodosPaginados(Pageable pageable) {
        return tipoActivoRepository.findAll(pageable);
    }

    @Override
    public List<TipoActivo> obtenerTodos() {
        return tipoActivoRepository.findAll();
    }

    @Override
    public Optional<TipoActivo> buscarPorId(Integer id) {
        return tipoActivoRepository.findById(id);
    }

    @Override
    public TipoActivo crearOEditar(TipoActivo tipoActivo) {
        return tipoActivoRepository.save(tipoActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        tipoActivoRepository.deleteById(id);
    }
}
