
package com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL;

import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones.AjusteInvetarioService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.AjusteInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AjusteInventarioBL
{
    // Representa La DB:
    @Autowired
    private AjusteInvetarioService _AjusteInvetarioService;


    // Obtiene Todos Los Registros De La DB
    public Page<AjusteInventario> buscarTodosPaginados(Pageable pageable)
    {
        return _AjusteInvetarioService.buscarTodosPaginados(pageable);
    }


    // Obtiene Todos Los Registros De La DB:
    public List<AjusteInventario> obtenerTodos()
    {
        return _AjusteInvetarioService.obtenerTodos();
    }


    // Obtiene Un Registro Encontrado Con Ese Id
    public Optional<AjusteInventario> buscarPorId(Integer id)
    {
        return _AjusteInvetarioService.buscarPorId(id);
    }


    // Recibe Un Objeto y Lo Guarda En La DB:
    public AjusteInventario crearOEditar(AjusteInventario ajusteInventario)
    {
        return _AjusteInvetarioService.crearOEditar(ajusteInventario);
    }


    // Obtiene Un Registro Encontrado Con Ese Id Y Lo Elimina
    public void eliminarPorId(Integer id)
    {
        _AjusteInvetarioService.eliminarPorId(id);
    }



}
