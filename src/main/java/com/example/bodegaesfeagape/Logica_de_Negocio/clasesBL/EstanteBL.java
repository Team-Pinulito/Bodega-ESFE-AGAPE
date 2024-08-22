package com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL;

import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.EstanteService;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.RolService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Estante;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstanteBL {

    @Autowired
    private EstanteService estanteService;

    public Page<Estante> buscarTodosPaginados(Pageable pageable){
        return estanteService.buscarTodosPaginados(pageable);
    }

    public List<Estante> obtenerTodos() {
        return estanteService.obtenerTodos();
    }

    public Optional<Estante> buscarPorId(Integer id) {
        return estanteService.buscarPorId(id);
    }

    public Estante crearOEditar(Estante estante) {
        return estanteService.crearOEditar(estante);
    }

    public void eliminarPorId(Integer id) {
        estanteService.eliminarPorId(id);
    }

}
