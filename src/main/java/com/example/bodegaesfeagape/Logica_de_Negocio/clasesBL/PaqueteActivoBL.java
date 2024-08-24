package com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.PaqueteActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.PaqueteActivo;

@Service
public class PaqueteActivoBL {
    @Autowired
    private PaqueteActivoService paqueteActivoService;

    public Page<PaqueteActivo> buscarTodosPaginados(Pageable pageable){
        return paqueteActivoService.buscarTodosPaginados(pageable);
    }

    public List<PaqueteActivo> obtenerTodos() {
        return paqueteActivoService.obtenerTodos();
    }

    public Optional<PaqueteActivo> buscarPorId(Integer id) {
        return paqueteActivoService.buscarPorId(id);
    }

    public PaqueteActivo crearOEditar(PaqueteActivo paqueteActivo) {
        return paqueteActivoService.crearOEditar(paqueteActivo);
    }

    public void eliminarPorId(Integer id) {
        paqueteActivoService.eliminarPorId(id);
    }   
}
