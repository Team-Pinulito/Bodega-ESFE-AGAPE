
package com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL;

import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.UsuarioService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioBL
{
    // Representa DB:
    @Autowired
    private UsuarioService _UsuarioService;

    // Obtiene Todos Los Registros De La DB
    public Page<Usuario> buscarTodosPaginados(Pageable pageable)
    {

        return _UsuarioService.buscarTodosPaginados(pageable);
    }


    // Obtiene Todos Los Registros De La DB:
    public List<Usuario> obtenerTodos()
    {
        return _UsuarioService.obtenerTodos();
    }


    // Obtiene Un Registro Encontrado Con Ese Id
    public Optional<Usuario> buscarPorId(Integer id)
    {
        return _UsuarioService.buscarPorId(id);
    }


    // Recibe Un Objeto y Lo Guarda En La DB:
    public Usuario crearOEditar(Usuario rol)
    {
        return _UsuarioService.crearOEditar(rol);
    }


    // Obtiene Un Registro Encontrado Con Ese Id Y Lo Elimina
    public void eliminarPorId(Integer id)
    {
        _UsuarioService.eliminarPorId(id);
    }



}
