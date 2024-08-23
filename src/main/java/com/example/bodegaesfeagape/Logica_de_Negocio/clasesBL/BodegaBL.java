package com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL;

import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.BodegaService;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.EstanteService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Bodega;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Estante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodegaBL {

    @Autowired
    private BodegaService bodegaService;

    public Page<Bodega> buscarTodosPaginados(Pageable pageable){
        return bodegaService.buscarTodosPaginados(pageable);
    }

    public List<Bodega> obtenerTodos() {
        return bodegaService.obtenerTodos();
    }

    public Optional<Bodega> buscarPorId(Integer id) {
        return bodegaService.buscarPorId(id);
    }

    public Bodega crearOEditar(Bodega bodega) {
        return bodegaService.crearOEditar(bodega);
    }

    public void eliminarPorId(Integer id) {
        bodegaService.eliminarPorId(id);
    }

}
