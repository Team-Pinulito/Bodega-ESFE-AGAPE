package com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.TipoActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.TipoActivo;

@Service
public class TipoActivoBL {
     @Autowired
    private TipoActivoService tipoActivoService;

    public Page<TipoActivo> buscarTodosPaginados(Pageable pageable){
        return tipoActivoService.buscarTodosPaginados(pageable);
    }

    public List<TipoActivo> obtenerTodos() {
        return tipoActivoService.obtenerTodos();
    }

    public Optional<TipoActivo> buscarPorId(Integer id) {
        return tipoActivoService.buscarPorId(id);
    }

    public TipoActivo crearOEditar(TipoActivo tipoActivo) {
        return tipoActivoService.crearOEditar(tipoActivo);
    }

    public void eliminarPorId(Integer id) {
        tipoActivoService.eliminarPorId(id);
    }
}
