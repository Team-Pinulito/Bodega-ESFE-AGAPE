
package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Usuario;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.RolBL;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.UsuarioBL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/usuario")
public class UsuarioController
{
    // Puente Con DB:
    @Autowired
    private UsuarioBL _UsuarioBL;

    @Autowired
    private RolBL _RolBL;


    // OBTIENE TODOS LOS REGISTROS Y LOS MANDA A LA VISTA:
    @GetMapping("/index")
    public String index(Model model)
    {

       List<Usuario> Usuarios_Registrados = _UsuarioBL.obtenerTodos();
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("Usuarios_Registrados", Usuarios_Registrados);



        return "Usuarios/Index";
    }


    // NOS MANDA A LA VISTA:
    @GetMapping("/create")
    public String create(Usuario usuario, Model model)
    {
        // Registros De Roles:
        List<Rol> Lista_Roles = _RolBL.obtenerTodos();
        model.addAttribute("Lista_Roles", Lista_Roles);
        model.addAttribute("usuario", usuario);

        return "Usuarios/Create";
    }


    // RECIBE UN OBJETO Y LO GUARDA EN LA DB:
    @PostMapping("/save")
    public String save(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes attributes) {

        // Validar Los Campos:
        if (result.hasErrors())
        {
            // Registros De Roles:
            List<Rol> Lista_Roles = _RolBL.obtenerTodos();
            model.addAttribute("Lista_Roles", Lista_Roles);
            model.addAttribute("usuario", usuario);

            return "Usuarios/Create";
        }

        _UsuarioBL.crearOEditar(usuario);
        attributes.addFlashAttribute("msg", "Usuario guardado correctamente");
        return "redirect:/usuario/index"; // Redirige a la lista de usuarios
    }


    // Busca Un Registro Con El Mismo ID en la DB:
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model)
    {
        Usuario Usuario_Obtenido = _UsuarioBL.buscarPorId(id).get();
        model.addAttribute("Usuario_Obtenido", Usuario_Obtenido);

        return "Usuarios/Details";
    }

    // Busca Un Registro Con El Mismo Id Y Nos Manda A La Vista:
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model)
    {

        // Registros De Roles:
        List<Rol> Lista_Roles = _RolBL.obtenerTodos();

        Usuario Usuario_Obtenido = _UsuarioBL.buscarPorId(id).get();
        model.addAttribute("Lista_Roles", Lista_Roles);
        model.addAttribute("Usuario_Obtenido", Usuario_Obtenido);

        return "/Usuarios/Edit";
    }

    // Nos Manda A La Vista Eliminar Con Un Registro Encontrado
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model)
    {
        Usuario Usuario_Obtenido = _UsuarioBL.buscarPorId(id).get();
        model.addAttribute("Usuario_Obtenido", Usuario_Obtenido);

        return "Usuarios/Delete";
    }

    // Busca El Registro Y Lo Elimina De La DB:
    @PostMapping("/delete")
    public String delete(Usuario usuario, RedirectAttributes attributes)
    {
        _UsuarioBL.eliminarPorId(usuario.getId());
        attributes.addFlashAttribute("msg", "Usuario Eliminado correctamente");

        return "redirect:/usuario/index";
    }

}
