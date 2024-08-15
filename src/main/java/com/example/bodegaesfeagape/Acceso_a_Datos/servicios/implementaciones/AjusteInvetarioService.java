package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IAjusteInventarioRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IAjusteInventarioService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.AjusteInventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AjusteInvetarioService implements IAjusteInventarioService {
    @Autowired
    private IAjusteInventarioRepository ajusterRepository;

    @Override
    public Page<AjusteInventario> buscarTodosPaginados(Pageable pageable) {
        return ajusterRepository.findAll(pageable);
    }

    @Override
    public List<AjusteInventario> obtenerTodos() {
        return ajusterRepository.findAll();
    }

    @Override
    public Optional<AjusteInventario> buscarPorId(Integer id) {
        return ajusterRepository.findById(id);
    }

    @Override
    public AjusteInventario crearOEditar(AjusteInventario ajusteInventario) {
        return ajusterRepository.save(ajusteInventario);
    }

    @Override
    public void eliminarPorId(Integer id) {
        ajusterRepository.deleteById(id);
    }
}
