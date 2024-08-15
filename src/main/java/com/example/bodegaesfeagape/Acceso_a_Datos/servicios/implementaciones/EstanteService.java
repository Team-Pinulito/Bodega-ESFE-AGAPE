package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IEstanteRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IEstanteService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Estante;

@Service
public class EstanteService implements IEstanteService{
    @Autowired
    private IEstanteRepository iEstanteRepository;

    @Override
    public List<Estante> obtenerTodos() {
        return iEstanteRepository.findAll();
    }

    @Override
    public Optional<Estante> buscarPorId(Integer id) {
        return iEstanteRepository.findById(id);
    }

    @Override
    public Estante crearOEditar(Estante estante) {
        return iEstanteRepository.save(estante);
    }

    @Override
    public void eliminarPorId(Integer id) {
        iEstanteRepository.deleteById(id);
    }
}
