package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IKardexActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IKardexActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.KardexActivo;

@Service
public class KardexActivoService implements IKardexActivoService{
    @Autowired
    private IKardexActivoRepository iKardexActivoRepository;

    @Override
    public List<KardexActivo> obtenerTodos() {
        return iKardexActivoRepository.findAll();
    }

    @Override
    public Optional<KardexActivo> buscarPorId(Integer  id) {
        return iKardexActivoRepository.findById(id);
    }

    @Override
    public KardexActivo crearOEditar(KardexActivo kardexActivo) {
        return iKardexActivoRepository.save(kardexActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        iKardexActivoRepository.deleteById(id);
    }
}
