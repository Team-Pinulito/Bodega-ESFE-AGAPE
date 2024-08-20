package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.RolBL;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolBL rolBL;

    @GetMapping("/create")
    public String create(Rol rol) {
        return "roles/create";
    }

    @PostMapping("/save")
    public String save(Rol rol, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(rol);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "roles/create";
        }

        rolBL.crearOEditar(rol);
        attributes.addFlashAttribute("msg", "Rol guardado correctamente");
        return "redirect:/home/index";
    }

}   
