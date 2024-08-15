package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IInventarioActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IIventarioActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.InventarioActivo;

public class InventarioActivoService implements IIventarioActivoService{
    @Autowired
    private IInventarioActivoRepository inventarioActivoRepository;

    @Override
    public Page<InventarioActivo> buscarTodosPaginados(Pageable pageable) {
        return inventarioActivoRepository.findAll(pageable);
    }

    @Override
    public List<InventarioActivo> obtenerTodos() {
        return inventarioActivoRepository.findAll();
    }

    @Override
    public Optional<InventarioActivo> buscarPorId(Integer id) {
        return inventarioActivoRepository.findById(id);
    }

    @Override
    public InventarioActivo crearOEditar(InventarioActivo inventarioActivo) {
        return inventarioActivoRepository.save(inventarioActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        inventarioActivoRepository.deleteById(id);
    }
}
