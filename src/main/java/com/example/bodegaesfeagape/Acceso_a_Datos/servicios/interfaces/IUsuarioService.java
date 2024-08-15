package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
     Page<Usuario> buscarTodosPaginados(Pageable pageable);

    List<Usuario> obtenerTodos();

    Optional<Usuario> buscarPorId(Integer id);

    Usuario crearOEditar(Usuario usuario);

    void eliminarPorId(Integer id);
}
