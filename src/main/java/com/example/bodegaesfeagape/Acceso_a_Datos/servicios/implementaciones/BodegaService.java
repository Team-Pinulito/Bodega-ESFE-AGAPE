package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IBodegaRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IBodegaService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Bodega;

import java.util.List;
import java.util.Optional;
@Service
public class BodegaService implements IBodegaService{
    @Autowired
    private IBodegaRepository iBodegaRepository;

    @Override
    public List<Bodega> obtenerTodos() {
        return iBodegaRepository.findAll();
    }

    @Override
    public Optional<Bodega> buscarPorId(Integer id) {
        return iBodegaRepository.findById(id);
    }

    @Override
    public Bodega crearOEditar(Bodega bodega) {
        return iBodegaRepository.save(bodega);
    }

    @Override
    public void eliminarPorId(Integer id) {
        iBodegaRepository.deleteById(id);
    }
}
