package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IRolRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IRolService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService {
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public Page<Rol> buscarTodosPaginados(Pageable pageable) {
        return rolRepository.findAll(pageable);
    }

    @Override
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> buscarPorId(Integer id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol crearOEditar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void eliminarPorId(Integer id) {
        rolRepository.deleteById(id);
    }
}
