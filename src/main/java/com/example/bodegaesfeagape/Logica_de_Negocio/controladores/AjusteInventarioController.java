package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import com.example.bodegaesfeagape.Entidades_de_Negocio.AjusteInventario;
import com.example.bodegaesfeagape.Entidades_de_Negocio.InventarioActivo;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Usuario;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.AjusteInventarioBL;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.UsuarioBL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/ajusteinventario")
public class AjusteInventarioController
{
    // Puentes Con DB:
    @Autowired
    private AjusteInventarioBL _AjusteInventarioBL;

    //@Autowired
    //private InventarioActivoBL InventarioActivoBL;

    @Autowired
    private UsuarioBL _UsuarioBL;



    // OBTIENE TODOS LOS REGISTROS Y LOS MANDA A LA VISTA:
    @GetMapping("/index")
    public String index(Model model)
    {
        List<AjusteInventario> Lista_AjusteInventario = _AjusteInventarioBL.obtenerTodos();
        model.addAttribute("Lista_AjusteInventario", Lista_AjusteInventario);

        return "AjusteInventarios/Index";
    }


    // NOS MANDA A LA VISTA:
    @GetMapping("/create")
    public String create(AjusteInventario ajusteInventario, Model model)
    {
        // Registros De InventarioActivo:
        //List<InventarioActivo> Lista_InventarioActivo = _InventarioActivoBL.obtenerTodos();
        //model.addAttribute("Lista_InventarioActivo", Lista_InventarioActivo);

        // Registros De Usuarios:
        List<Usuario> Lista_Usuarios = _UsuarioBL.obtenerTodos();
        model.addAttribute("Lista_Usuarios", Lista_Usuarios);

        model.addAttribute("ajusteInventario", ajusteInventario);

        return "AjusteInventarios/Create";
    }


    // RECIBE UN OBJETO Y LO GUARDA EN LA DB:
    @PostMapping("/save")
    public String save(@Valid AjusteInventario ajusteInventario, BindingResult result, Model model, RedirectAttributes attributes)
    {
        // Validar Los Campos:
        if (result.hasErrors())
        {
            // Registros De InventarioActivo:
            //List<InventarioActivo> Lista_InventarioActivo = _InventarioActivoBL.obtenerTodos();
            //model.addAttribute("Lista_InventarioActivo", Lista_InventarioActivo);

            // Registros De Usuarios:
            List<Usuario> Lista_Usuarios = _UsuarioBL.obtenerTodos();
            model.addAttribute("Lista_Usuarios", Lista_Usuarios);

            model.addAttribute("ajusteInventario", ajusteInventario);

            return "AjusteInventarios/Create";
        }

        // Guardando
        _AjusteInventarioBL.crearOEditar(ajusteInventario);
        attributes.addFlashAttribute("msg", "Usuario guardado correctamente");

        return "redirect:/ajusteinventario/index"; // Redirige a la lista de usuarios
    }


    // Busca Un Registro Con El Mismo ID en la DB:
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model)
    {
        AjusteInventario Objeto_Obtenido = _AjusteInventarioBL.buscarPorId(id).get();
        model.addAttribute("Objeto_Obtenido", Objeto_Obtenido);

        return "AjusteInventarios/Details";
    }


    // Busca Un Registro Con El Mismo Id Y Nos Manda A La Vista:
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        // Registro Encontrado:
        AjusteInventario Objeto_Obtenido = _AjusteInventarioBL.buscarPorId(id).get();

        // Registros De InventarioActivo:
        //List<InventarioActivo> Lista_InventarioActivo = _InventarioActivoBL.obtenerTodos();
        //model.addAttribute("Lista_InventarioActivo", Lista_InventarioActivo);

        // Registros De Usuarios:
        List<Usuario> Lista_Usuarios = _UsuarioBL.obtenerTodos();
        model.addAttribute("Lista_Usuarios", Lista_Usuarios);

        model.addAttribute("Objeto_Obtenido", Objeto_Obtenido);


        return "/AjusteInventarios/Edit";
    }


    // Nos Manda A La Vista Eliminar Con Un Registro Encontrado
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model)
    {
        // Registro Encontrado:
        AjusteInventario Objeto_Obtenido = _AjusteInventarioBL.buscarPorId(id).get();
        model.addAttribute("Objeto_Obtenido", Objeto_Obtenido);

        return "AjusteInventarios/Delete";
    }


    // Busca El Registro Y Lo Elimina De La DB:
    @PostMapping("/delete")
    public String delete(AjusteInventario ajusteInventario, RedirectAttributes attributes)
    {
        _AjusteInventarioBL.eliminarPorId(ajusteInventario.getId());
        attributes.addFlashAttribute("msg", "Ajuste Inventario Eliminado correctamente");

        return "redirect:/ajusteinventario/index";
    }


}