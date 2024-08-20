package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.RolBL;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolBL rolBL;

    @GetMapping("/index")
    public String index(Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);

        Page<Rol> roles = rolBL.buscarTodosPaginados(pageable);
        model.addAttribute("roles", roles);

        if (roles.getTotalPages() > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, roles.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "roles/index";
    }

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
        return "redirect:/roles/index";
    }

}
