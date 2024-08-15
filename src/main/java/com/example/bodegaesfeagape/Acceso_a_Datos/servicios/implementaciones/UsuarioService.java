package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;

import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IUsuarioRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IUsuarioService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> buscarTodosPaginados(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario crearOEditar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
