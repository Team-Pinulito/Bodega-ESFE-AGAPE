package com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.RolService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;

@Service
public class RolBL {

    @Autowired
    private RolService rolService;

    public Page<Rol> buscarTodosPaginados(Pageable pageable){
        return rolService.buscarTodosPaginados(pageable);
    }

    public List<Rol> obtenerTodos() {
        return rolService.obtenerTodos();
    }

    public Optional<Rol> buscarPorId(Integer id) {
        return rolService.buscarPorId(id);
    }

    public Rol crearOEditar(Rol rol) {
        return rolService.crearOEditar(rol);
    }

    public void eliminarPorId(Integer id) {
        rolService.eliminarPorId(id);
    }

}
