package com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.ActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Activo;
import org.springframework.stereotype.Service;

@Service
public class ActivoBL {
 @Autowired
    private ActivoService activoService;

    public Page<Activo> buscarTodosPaginados(Pageable pageable){
        return activoService.buscarTodosPaginados(pageable);
    }

    public List<Activo> obtenerTodos() {
        return activoService.obtenerTodos();
    }

    public Optional<Activo> buscarPorId(Integer id) {
        return activoService.buscarPorId(id);
    }

    public Activo crearOEditar(Activo activo) {
        return activoService.crearOEditar(activo);
    }

    public void eliminarPorId(Integer id) {
        activoService.eliminarPorId(id);
    }

}
